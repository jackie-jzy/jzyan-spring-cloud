package cn.jzyan.oauth2.utils;

import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.jwt.crypto.sign.SignatureVerifier;
import org.springframework.security.jwt.crypto.sign.Signer;
import org.springframework.security.oauth2.common.util.JsonParser;
import org.springframework.security.oauth2.common.util.JsonParserFactory;

import java.util.Map;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : JwtUtil
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.utils
 * @Description : JwtUtil
 * @Author : jzyan
 * @CreateDate : 2020/05/29 18:19
 */
public class JwtUtil {
    private static final String EXP = "exp";
    private static JsonParser objectMapper = JsonParserFactory.create();

    private JwtUtil() {
    }

    /**
     * 解析jwt
     *
     * @param verifierKey
     * @param jwtValue
     * @return
     */
    public static Map<String, Object> encrypt(String verifierKey, String jwtValue) {
        SignatureVerifier verifier = new MacSigner(verifierKey);
        Jwt jwt = JwtHelper.decodeAndVerify(jwtValue, verifier);
        String claimsStr = jwt.getClaims();
        Map<String, Object> claims = objectMapper.parseMap(claimsStr);
        if (claims.containsKey(EXP) && claims.get(EXP) instanceof Integer) {
            Integer intValue = (Integer) claims.get(EXP);
            claims.put(EXP, Long.valueOf(intValue));
        }
        return claims;
    }

    /**
     * 生成jwt
     *
     * @param verifierKey
     * @param map
     * @return
     */
    public static String encode(String verifierKey, Map<String, Object> map) {
        Signer signer = new MacSigner(verifierKey);
        String token = JwtHelper.encode(objectMapper.formatMap(map), signer).getEncoded();
        return token;
    }
}
