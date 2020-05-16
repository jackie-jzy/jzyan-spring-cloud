package cn.jzyan.gateway.controller;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.gateway.entity.GatewayDefine;
import cn.jzyan.gateway.service.GatewayDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : GatewayDefineController
 * @Version : 1.0.0
 * @Package : cn.jzyan.gateway.controller
 * @Description : 路由配置
 * @Author : jzyan
 * @CreateDate : 2020/05/15 15:12
 */
@RestController
@RequestMapping("/gateway")
public class GatewayDefineController {

    @Autowired
    private GatewayDefineService gatewayDefineService;

    @PostMapping("/save")
    public BaseResponse save(@RequestBody GatewayDefine gatewayDefine) {
        gatewayDefineService.save(gatewayDefine);
        return new BaseResponse();
    }

    @PostMapping("/update")
    public BaseResponse update(@RequestBody GatewayDefine gatewayDefine) {
        gatewayDefineService.update(gatewayDefine);
        return new BaseResponse();
    }

}
