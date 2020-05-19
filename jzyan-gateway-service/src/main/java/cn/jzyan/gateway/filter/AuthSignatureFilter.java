package cn.jzyan.gateway.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : AuthSignatureFilter
 * @Version : 1.0.0
 * @Package : cn.jzyan.gateway.filter
 * @Description : 全局拦截器
 * @Author : jzyan
 * @CreateDate : 2020/05/18 15:55
 */
@Slf4j
@Order(-200)
@Component
public class AuthSignatureFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        log.info("Request: {}", JSON.toJSONString(request));

        List<String> httpHeaders = request.getHeaders().get(HttpHeaders.AUTHORIZATION);
        //转发添加 Authorization认证header头
        String authorization = null;
        if (httpHeaders != null) {
            authorization = httpHeaders.get(0);
        } else {
            List<String> queryParams = request.getQueryParams().get(HttpHeaders.AUTHORIZATION);
            if (queryParams != null) {
                authorization = queryParams.get(0);
            }
        }
        ServerWebExchange build = exchange.mutate().request(exchange.getRequest().mutate().header(HttpHeaders.AUTHORIZATION, authorization).build()).build();
        return chain.filter(build);
    }
}
