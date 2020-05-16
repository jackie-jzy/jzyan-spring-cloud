package cn.jzyan.gateway.service;

import cn.jzyan.gateway.entity.GatewayDefine;

import java.net.URISyntaxException;
import java.util.List;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : GatewayDefineService
 * @Version : 1.0.0
 * @Package : cn.jzyan.gateway.service
 * @Description : 路由
 * @Author : jzyan
 * @CreateDate : 2020/05/15 10:28
 */
public interface GatewayDefineService {

    List<GatewayDefine> findAll();

    void save(GatewayDefine gatewayDefine);

    void deleteById(Integer id);

    boolean existsById(Integer id);

    void update(GatewayDefine gatewayDefine);

    void saveRouteDefinitionToRedis(GatewayDefine gatewayDefine) throws URISyntaxException;
}
