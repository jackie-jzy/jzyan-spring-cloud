package cn.jzyan.oauth2.service.impl;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.oauth2.enhancer.CustomTokenEnhancer;
import cn.jzyan.oauth2.entity.*;
import cn.jzyan.oauth2.exception.AccessTokenException;
import cn.jzyan.oauth2.exception.ClientDetailsException;
import cn.jzyan.oauth2.service.AuthenticationService;
import cn.jzyan.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    @Qualifier("ClientDetailsServiceImpl")
    private ClientDetailsService clientDetailsService;
    @Autowired
    @Qualifier("redisTokenStore")
    private TokenStore tokenStore;
    @Autowired
    private CustomTokenEnhancer customTokenEnhancer;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Value("${oauth2.clientId}")
    private String clientId;

    /**
     * 后端登录
     *
     * @param loginRequest
     * @return
     */
    @Override
    public BaseResponse loginWeb(LoginRequest loginRequest) {
        Map<String, String> parameters = new HashMap<>(4);
        parameters.put("grant_type", "password");
        parameters.put("username", loginRequest.getUsername());
        parameters.put("password", loginRequest.getPassword());
        parameters.put("scope", "all");

        OAuth2AccessToken oAuth2AccessToken = this.getToken(parameters);

        //校验登录
        BaseResponse<LoginResponse> response;
        SystemUser systemUser = userService.findByUsername(loginRequest.getUsername());
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setAccessToken(oAuth2AccessToken.getValue());
        loginResponse.setExpiresIn(oAuth2AccessToken.getExpiresIn());
        loginResponse.setName(systemUser.getName());
        loginResponse.setUserId(systemUser.getId());
        if (systemUser == null) {
            response = new RestResponse<>(ErrorCodeEnum.ERROR_601);
        } else {
            if (passwordEncoder.matches(loginRequest.getPassword(), systemUser.getPassword())) {
                response = new RestResponse<>(loginResponse);
            } else {
                response = new RestResponse<>(ErrorCodeEnum.ERROR_601);
            }
        }
        return response;
    }

    /**
     * 获取token
     *
     * @param parameters
     * @return
     */
    private OAuth2AccessToken getToken(Map<String, String> parameters) {
        //生成token
        ClientDetails client = clientDetailsService.loadClientByClientId(clientId);
        if (client == null) {
            throw new ClientDetailsException(ErrorCodeEnum.ERROR_603);
        }
        TokenRequest tokenRequest = new TokenRequest(parameters, clientId, client.getScope(), parameters.get(OAuth2Utils.GRANT_TYPE));
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore);
        defaultTokenServices.setClientDetailsService(clientDetailsService);
        defaultTokenServices.setTokenEnhancer(getTokenEnhancerChain());
        // 是否支持刷新Token
        defaultTokenServices.setSupportRefreshToken(true);
        defaultTokenServices.setAccessTokenValiditySeconds(client.getAccessTokenValiditySeconds());
        defaultTokenServices.setRefreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds());
        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(tokenRequest.createOAuth2Request(client), null);
        OAuth2AccessToken token = defaultTokenServices.createAccessToken(oAuth2Authentication);
        if (token == null) {
            throw new AccessTokenException(ErrorCodeEnum.ERROR_602);
        }
        return token;
    }

    /**
     * 采用token转jwt，并添加一些自定义信息（token增强）（有默认非必须）
     *
     * @return
     */
    private TokenEnhancerChain getTokenEnhancerChain() {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(
                Arrays.asList(jwtAccessTokenConverter, customTokenEnhancer));
        return tokenEnhancerChain;
    }
}
