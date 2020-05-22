package cn.jzyan.oauth2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : AuthenticationController
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.controller
 * @Description :
 * @Author : jzyan
 * @CreateDate : 2020/04/29 9:47
 */
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping("/web/login")
    public Object webLogin(User user) {
        log.info("user:{}", user);
        return user;
    }

}
