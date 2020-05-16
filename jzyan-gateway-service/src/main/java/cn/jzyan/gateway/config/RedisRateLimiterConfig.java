package cn.jzyan.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : RedisRateLimiterConfig
 * @Version : 1.0.0
 * @Package : cn.jzyan.gateway.config
 * @Description : 限流策略
 * @Author : jzyan
 * @CreateDate : 2020/05/13 15:56
 */
@Configuration
public class RedisRateLimiterConfig {

    /**
     * ip 限流
     *
     * @return
     */
    @Primary
    @Bean(value = "ipKeyResolver")
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

    /**
     * 用户限流
     *
     * @return
     */
    @Bean(value = "userKeyResolver")
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("username"));
    }

    /**
     * API限流
     *
     * @return
     */
    @Bean(value = "apiKeyResolver")
    KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }

}
