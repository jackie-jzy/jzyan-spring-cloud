package cn.jzyan.oauth2.service;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.oauth2.entity.auth.LoginRequest;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : AuthenticationService
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.service
 * @Description : 登录
 * @Author : jzyan
 * @CreateDate : 2020/05/25 11:51
 */
public interface AuthenticationService {

    /**
     * 后端登录
     *
     * @param loginRequest
     * @return
     */
    BaseResponse loginAdmin(LoginRequest loginRequest);

    /**
     * app登录
     *
     * @param loginRequest
     * @return
     */
    BaseResponse loginApp(LoginRequest loginRequest);
}
