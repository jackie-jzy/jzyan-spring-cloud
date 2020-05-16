package cn.jzyan.gateway.service;

import cn.jzyan.gateway.entity.GatewayDefine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.net.URISyntaxException;
import java.util.List;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : GatewayService
 * @Version : 1.0.0
 * @Package : cn.jzyan.gateway.service
 * @Description : 路由信息缓存到redis
 * @Author : jzyan
 * @CreateDate : 2020/05/15 11:53
 */
@Slf4j
@Service
public class GatewayService implements ApplicationEventPublisherAware, CommandLineRunner {

    private ApplicationEventPublisher publisher;
    @Autowired
    private GatewayDefineService gatewayDefineService;

    @Override
    public void run(String... args) {
        this.loadRouteDefinition();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    private String loadRouteDefinition() {
        List<GatewayDefine> gatewayDefines = gatewayDefineService.findAll();
        if (CollectionUtils.isEmpty(gatewayDefines)) {
            return "none route defined";
        }
        try {
            for (GatewayDefine gatewayDefine : gatewayDefines) {
                gatewayDefineService.saveRouteDefinitionToRedis(gatewayDefine);
            }
            publisher.publishEvent(new RefreshRoutesEvent(this));
            return "success";
        } catch (URISyntaxException e) {
            log.error("URISyntax-----------------异常:{}", e);
            return "failure";
        }
    }


}
