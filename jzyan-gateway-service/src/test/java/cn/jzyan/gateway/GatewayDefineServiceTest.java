package cn.jzyan.gateway;

import cn.jzyan.gateway.entity.GatewayDefine;
import cn.jzyan.gateway.service.GatewayDefineService;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : GatewayDefineService
 * @Version : 1.0.0
 * @Package : cn.jzyan.gateway
 * @Description : TODO
 * @Author : jzyan
 * @CreateDate : 2020/05/19 11:20
 */
public class GatewayDefineServiceTest extends GatewayServiceApplicationTests {

    @Autowired
    private GatewayDefineService gatewayDefineService;


    @Test
    public void saveTest(){
        Map<String, String> args = new HashMap<>();
        args.put("pattern","/auth/**");

        List<PredicateDefinition> predicates = new ArrayList<>();

        PredicateDefinition predicateDefinition = new PredicateDefinition();
        predicateDefinition.setName("Path");
        predicateDefinition.setArgs(args);
        predicates.add(predicateDefinition);

        GatewayDefine gatewayDefine = new GatewayDefine();
        gatewayDefine.setRouteId("oauth2_route");
        gatewayDefine.setUri("lb://oauth2-local-service");
        gatewayDefine.setPredicates(JSON.toJSONString(predicates));

        gatewayDefineService.save(gatewayDefine);
    }

    @Test
    public void updateTest(){
        Map<String, String> args = new HashMap<>();
        args.put("pattern","/auth/**");

        List<PredicateDefinition> predicates = new ArrayList<>();

        PredicateDefinition predicateDefinition = new PredicateDefinition();
        predicateDefinition.setName("Path");
        predicateDefinition.setArgs(args);
        predicates.add(predicateDefinition);


        GatewayDefine gatewayDefine = new GatewayDefine();
        gatewayDefine.setId(2);
        gatewayDefine.setPredicates(JSON.toJSONString(predicates));

        gatewayDefineService.update(gatewayDefine);
    }
}
