package cn.jzyan.gateway.service.impl;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.bean.utils.BeanUtil;
import cn.jzyan.gateway.entity.GatewayDefine;
import cn.jzyan.gateway.entity.RestResponse;
import cn.jzyan.gateway.repository.GatewayDefineRepository;
import cn.jzyan.gateway.repository.RedisRouteDefinitionRepository;
import cn.jzyan.gateway.service.GatewayDefineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : GatewayDefineServiceImpl
 * @Version : 1.0.0
 * @Package : cn.jzyan.gateway.service.impl
 * @Description : 路由
 * @Author : jzyan
 * @CreateDate : 2020/05/15 10:30
 */
@Slf4j
@Service
public class GatewayDefineServiceImpl implements GatewayDefineService {

    @Autowired
    private GatewayDefineRepository gatewayDefineRepository;
    @Autowired
    private RedisRouteDefinitionRepository routeDefinitionWriter;

    @Override
    public List<GatewayDefine> findAll() {
        return gatewayDefineRepository.findAll();
    }

    @Override
    public BaseResponse save(GatewayDefine gatewayDefine) {
        gatewayDefine = gatewayDefineRepository.save(gatewayDefine);
        try {
            this.saveRouteDefinitionToRedis(gatewayDefine);
        } catch (URISyntaxException e) {
            log.error("URISyntax-----------------异常:{}", e);
        }
        return new RestResponse();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse deleteById(Integer id) {
        Optional<GatewayDefine> optional = gatewayDefineRepository.findById(id);
        if (optional.isPresent()) {
            GatewayDefine gatewayDefine = optional.get();
            routeDefinitionWriter.delete(Mono.just(gatewayDefine.getRouteId())).subscribe();
        }
        gatewayDefineRepository.deleteById(id);
        return new RestResponse();
    }

    @Override
    public BaseResponse<Boolean> existsById(Integer id) {
        boolean b = gatewayDefineRepository.existsById(id);
        return new RestResponse<>(b);
    }

    @Override
    public BaseResponse update(GatewayDefine gatewayDefine) {
        Optional<GatewayDefine> optional = gatewayDefineRepository.findById(gatewayDefine.getId());
        if (optional.isPresent()) {
            GatewayDefine gatewayDefineUpdate = optional.get();
            BeanUtil.copyPropertiesIgnoreNull(gatewayDefine, gatewayDefineUpdate);
            try {
                this.saveRouteDefinitionToRedis(gatewayDefineUpdate);
            } catch (URISyntaxException e) {
                log.error("URISyntax-----------------异常:{}", e);
            }
            gatewayDefineRepository.save(gatewayDefineUpdate);
        }
        return new RestResponse();
    }

    /**
     * 保存路由到redis中
     *
     * @param gatewayDefine
     * @throws URISyntaxException
     */
    @Override
    public void saveRouteDefinitionToRedis(GatewayDefine gatewayDefine) throws URISyntaxException {
        RouteDefinition definition = new RouteDefinition();
        definition.setId(gatewayDefine.getRouteId());
        definition.setUri(new URI(gatewayDefine.getUri()));

        List<PredicateDefinition> predicateDefinitions = gatewayDefine.getPredicateDefinition();
        if (!CollectionUtils.isEmpty(predicateDefinitions)) {
            definition.setPredicates(predicateDefinitions);
        }

        List<FilterDefinition> filterDefinitions = gatewayDefine.getFilterDefinition();
        if (!CollectionUtils.isEmpty(filterDefinitions)) {
            definition.setFilters(filterDefinitions);
        }
        routeDefinitionWriter.save(Mono.just(definition)).subscribe();
    }

    @Override
    public BaseResponse<GatewayDefine> findById(Integer id) {
        GatewayDefine gatewayDefine = gatewayDefineRepository.getOne(id);
        return new RestResponse<>(gatewayDefine);
    }

}
