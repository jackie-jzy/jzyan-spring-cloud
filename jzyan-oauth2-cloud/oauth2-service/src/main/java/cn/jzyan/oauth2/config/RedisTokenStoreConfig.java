package cn.jzyan.oauth2.config;

import cn.jzyan.oauth2.service.RedisAuthorizationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : RedisTokenStoreConfig
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.config
 * @Description : RedisTokenStoreConfig
 * @Author : jzyan
 * @CreateDate : 2020/04/30 11:04
 */
@Configuration
public class RedisTokenStoreConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    /**
     * 配置授权码模式授权码服务,不配置默认为内存模式
     *
     * @return
     */
    @Primary
    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new RedisAuthorizationCodeService(redisConnectionFactory);
    }

}
