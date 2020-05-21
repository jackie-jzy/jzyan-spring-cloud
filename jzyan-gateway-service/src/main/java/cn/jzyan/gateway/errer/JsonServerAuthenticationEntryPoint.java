package cn.jzyan.gateway.errer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : JsonServerAuthenticationEntryPoint
 * @Version : 1.0.0
 * @Package : cn.jzyan.gateway.errer
 * @Description : TODO
 * @Author : jzyan
 * @CreateDate : 2020/05/21 18:28
 */
@Component
public class JsonServerAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {


    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json; charset=UTF-8");
        Map<String, Object> mpa = new HashMap<>(3);
        mpa.put("code", 401);
        mpa.put("message", "invalid access token,please check");
        mpa.put("data", null);
        byte[] dataBytes = JSON.toJSONString(mpa, SerializerFeature.WriteMapNullValue).getBytes();
        DataBuffer bodyDataBuffer = response.bufferFactory().wrap(dataBytes);
        return response.writeWith(Mono.just(bodyDataBuffer));
    }
}
