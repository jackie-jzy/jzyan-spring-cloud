package cn.jzyan.gateway;

import cn.jzyan.gateway.entity.GatewayDefine;
import com.alibaba.fastjson.JSON;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : Test
 * @Version : 1.0.0
 * @Package : cn.jzyan.gateway
 * @Description : TODO
 * @Author : jzyan
 * @CreateDate : 2020/05/15 19:37
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void test(){
        Map<String, String> args = new HashMap<>();
        args.put("pattern","/ribbon/**");

        List<PredicateDefinition> predicates = new ArrayList<>();

        PredicateDefinition predicateDefinition = new PredicateDefinition();
        predicateDefinition.setName("Path");
        predicateDefinition.setArgs(args);
        predicates.add(predicateDefinition);

        GatewayDefine gatewayDefine = new GatewayDefine();
        gatewayDefine.setRouteId("ribbon_route");
        gatewayDefine.setUri("lb://ribbon-local-service");
        gatewayDefine.setPredicates(JSON.toJSONString(predicates));

        System.out.println(JSON.toJSONString(gatewayDefine));
    }
}
