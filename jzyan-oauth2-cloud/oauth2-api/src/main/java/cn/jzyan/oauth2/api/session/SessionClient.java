package cn.jzyan.oauth2.api.session;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.bean.SessionUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : SessionClient
 * @Version : 1.0
 * @Package : cn.jzyan.oauth2.api.session
 * @Description : session
 * @Author : jzyan
 * @CreateDate : 2020/06/02 10:49
 */
@FeignClient(value = "${oauth2-service.name}", fallback = SessionClientFallback.class)
public interface SessionClient {

    @GetMapping("/auth/session/user/info")
    BaseResponse<SessionUser> getUserInfo(@RequestParam String authorization);

}
