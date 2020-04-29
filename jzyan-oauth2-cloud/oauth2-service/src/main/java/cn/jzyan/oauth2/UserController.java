package cn.jzyan.oauth2;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : UserController
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2
 * @Description : TODO
 * @Author : jzyan
 * @CreateDate : 2020/04/27 17:41
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }

}
