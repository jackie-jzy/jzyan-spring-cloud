package cn.jzyan.oauth2.controller;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.oauth2.entity.LoginRequest;
import cn.jzyan.oauth2.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : AuthenticationEndpoint
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.controller
 * @Description : 登录
 * @Author : jzyan
 * @CreateDate : 2020/05/23 15:46
 */
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/web/login")
    public BaseResponse loginWeb(@RequestBody LoginRequest loginRequest) {
        return authenticationService.loginWeb(loginRequest);
    }


}
