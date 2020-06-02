package cn.jzyan.oauth2.controller;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.bean.constant.Constants;
import cn.jzyan.oauth2.bean.session.SessionUser;
import cn.jzyan.oauth2.entity.RestResponse;
import cn.jzyan.oauth2.entity.user.AdminUser;
import cn.jzyan.oauth2.service.UserService;
import cn.jzyan.oauth2.utils.JwtUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : SessionController
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.controller
 * @Description : session 管理
 * @Author : jzyan
 * @CreateDate : 2020/05/29 18:06
 */
@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/user/info")
    public BaseResponse<SessionUser> getUserInfo(@RequestParam String authorization) {
        Map<String, Object> claims = JwtUtil.encrypt(jwtAccessTokenConverter.getKey().get("value"), authorization);
        String userName = (String) claims.get("user_name");
        String value = (String) stringRedisTemplate.opsForHash().get(Constants.Oauth.AUTH_USER_ADMIN_PREFIX, userName);
        SessionUser sessionUser = new SessionUser();
        if (value != null) {
            sessionUser = JSON.parseObject(value, SessionUser.class);
        } else {
            AdminUser adminUser = userService.findByUsername(userName);
            BeanUtils.copyProperties(adminUser, sessionUser);
        }
        return new RestResponse(sessionUser);
    }

}
