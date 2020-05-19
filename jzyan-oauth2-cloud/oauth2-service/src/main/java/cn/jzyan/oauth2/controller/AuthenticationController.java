package cn.jzyan.oauth2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

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
public class AuthenticationController {

    @GetMapping("user")
    public Object userInfo(Principal user) {
        log.info("user:{}", user);
        return user;
    }

}
