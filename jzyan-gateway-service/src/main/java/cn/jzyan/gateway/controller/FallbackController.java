package cn.jzyan.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : FallbackController
 * @Version : 1.0.0
 * @Package : cn.jzyan.gateway.controller
 * @Description : 服务降级回调
 * @Author : jzyan
 * @CreateDate : 2020/05/13 15:48
 */
@RestController
public class FallbackController {


    @GetMapping("/fallback")
    public Object fallback() {
        Map<String, Object> result = new HashMap<>(3);
        result.put("data", null);
        result.put("message", "Get request fallback!");
        result.put("code", 500);
        return result;
    }

}
