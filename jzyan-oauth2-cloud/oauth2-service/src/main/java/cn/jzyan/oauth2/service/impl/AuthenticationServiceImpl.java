package cn.jzyan.oauth2.service.impl;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.oauth2.entity.*;
import cn.jzyan.oauth2.exception.AccessTokenException;
import cn.jzyan.oauth2.exception.ClientDetailsException;
import cn.jzyan.oauth2.service.AuthenticationService;
import cn.jzyan.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.jwt.crypto.sign.SignatureVerifier;
import org.springframework.security.jwt.crypto.sign.Signer;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.util.JsonParser;
import org.springframework.security.oauth2.common.util.JsonParserFactory;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : AuthenticationServiceImpl
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.service.impl
 * @Description : 登录
 * @Author : jzyan
 * @CreateDate : 2020/05/25 11:51
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
    private JsonParser objectMapper = JsonParserFactory.create();
    private final String EXP = "exp";

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    @Qualifier("ClientDetailsServiceImpl")
    private ClientDetailsService clientDetailsService;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    @Qualifier("redisTokenStore")
    private TokenStore tokenStore;

    @Value("${oauth2.clientId}")
    private String clientId;

    /**
     * 后端登录
     *
     * @param loginRequest
     * @return
     */
    @Override
    public BaseResponse loginAdmin(LoginRequest loginRequest) {
        BaseResponse<LoginResponse> response;
        //获取登录用户
        SystemUser systemUser = userService.findByUsername(loginRequest.getUsername());
        if (systemUser == null) {
            response = new RestResponse<>(ErrorCodeEnum.ERROR_601);
        } else {
            if (passwordEncoder.matches(loginRequest.getPassword(), systemUser.getPassword())) {
                LoginResponse loginResponse = new LoginResponse();
                Map<String, String> parameters = new HashMap<>(4);
                parameters.put("grant_type", "password");
                parameters.put("username", loginRequest.getUsername());
                parameters.put("password", loginRequest.getPassword());
                parameters.put("scope", "all");

                //生成token
                Authentication userAuth = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
                OAuth2AccessToken oAuth2AccessToken = this.getToken(parameters, true, userAuth);
                //缓存用户信息

                //获取jwt
                String value = this.getJwt(systemUser.getId(), null, oAuth2AccessToken.getValue());

                loginResponse.setAccessToken(value);
                loginResponse.setExpiresIn(oAuth2AccessToken.getExpiresIn());
                loginResponse.setName(systemUser.getName());
                response = new RestResponse<>(loginResponse);
            } else {
                response = new RestResponse<>(ErrorCodeEnum.ERROR_601);
            }
        }
        return response;
    }

    /**
     * app登录
     *
     * @param loginRequest
     * @return
     */
    @Override
    public BaseResponse loginApp(LoginRequest loginRequest) {
        return null;
    }

    /**
     * 获取token
     *
     * @param parameters
     * @return
     */
    private OAuth2AccessToken getToken(Map<String, String> parameters, boolean supportRefreshToken, Authentication userAuth) {
        //生成token
        ClientDetails client = clientDetailsService.loadClientByClientId(clientId);
        if (client == null) {
            throw new ClientDetailsException(ErrorCodeEnum.ERROR_603);
        }
        defaultTokenServices.setClientDetailsService(clientDetailsService);
        defaultTokenServices.setTokenStore(tokenStore);
        defaultTokenServices.setAccessTokenValiditySeconds(client.getAccessTokenValiditySeconds());
        defaultTokenServices.setRefreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds());
        defaultTokenServices.setTokenEnhancer(jwtAccessTokenConverter);
        defaultTokenServices.setSupportRefreshToken(supportRefreshToken);

        TokenRequest tokenRequest = new TokenRequest(parameters, clientId, client.getScope(), parameters.get(OAuth2Utils.GRANT_TYPE));
        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(tokenRequest.createOAuth2Request(client), userAuth);
        OAuth2AccessToken token = defaultTokenServices.createAccessToken(oAuth2Authentication);
        if (token == null) {
            throw new AccessTokenException(ErrorCodeEnum.ERROR_602);
        }
        return token;
    }


    /**
     * 获取jwt
     *
     * @param userId
     * @param roleIds
     * @param jwtValue
     * @return
     */
    private String getJwt(Integer userId, Set<Integer> roleIds, String jwtValue) {
        String verifierKey = jwtAccessTokenConverter.getKey().get("value");
        SignatureVerifier verifier = new MacSigner(verifierKey);
        Signer signer = new MacSigner(verifierKey);

        Jwt jwt = JwtHelper.decodeAndVerify(jwtValue, verifier);
        String claimsStr = jwt.getClaims();

        Map<String, Object> claims = objectMapper.parseMap(claimsStr);
        if (claims.containsKey(EXP) && claims.get(EXP) instanceof Integer) {
            Integer intValue = (Integer) claims.get(EXP);
            claims.put(EXP, Long.valueOf(intValue));
        }
        claims.put("user_id", userId);
        claims.put("role_id", roleIds);
        String token = JwtHelper.encode(objectMapper.formatMap(claims), signer).getEncoded();
        return token;
    }

}
