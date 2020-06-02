package cn.jzyan.system.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName : jzyan-base-package
 * @FileName : AuthorityInterceptor
 * @Version : 1.0.0
 * @Package : cn.jzyan.global.interceptor
 * @Description : 获取session
 * @Author : jzyan
 * @CreateDate : 2020/04/24 14:09
 */
@Component
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (null == authorization) {
            authorization = request.getParameter(HttpHeaders.AUTHORIZATION);
        }
        System.out.println(authorization);
        return true;
    }

}