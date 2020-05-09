package cn.jzyan.oauth2.enhancer;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : JwtTokenEnhancer
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.service.impl
 * @Description : CustomTokenEnhancer
 * @Author : jzyan
 * @CreateDate : 2020/04/29 17:52
 */
public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> info = new HashMap<>(1);
        info.put("enhance", "enhance info");
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }

}
