package cn.jzyan.oauth2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : JwtTokenStoreConfig
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.config
 * @Description : JwtTokenStoreConfig
 * @Author : jzyan
 * @CreateDate : 2020/04/29 17:50
 */
@Configuration
public class JwtTokenStoreConfig {

    @Value("${jwt.signing.key}")
    private String signingKey;

    @Bean
    @Primary
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        // 配置jwt使用的密钥
        jwtAccessTokenConverter.setSigningKey(signingKey);
        return jwtAccessTokenConverter;
    }

}
