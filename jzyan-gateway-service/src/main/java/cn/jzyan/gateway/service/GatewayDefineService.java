package cn.jzyan.gateway.service;

import cn.jzyan.bean.BaseResponse;
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

    BaseResponse save(GatewayDefine gatewayDefine);

    BaseResponse deleteById(Integer id);

    BaseResponse<Boolean> existsById(Integer id);

    BaseResponse update(GatewayDefine gatewayDefine);

    void saveRouteDefinitionToRedis(GatewayDefine gatewayDefine) throws URISyntaxException;

    BaseResponse<GatewayDefine> findById(Integer id);

}
