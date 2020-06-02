package cn.jzyan.system.interceptor;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.bean.SessionUser;
import cn.jzyan.bean.constant.BaseErrorCodeEnum;
import cn.jzyan.bean.constant.Constants;
import cn.jzyan.bean.exception.SessionException;
import cn.jzyan.bean.exception.SystemException;
import cn.jzyan.global.context.SessionContext;
import cn.jzyan.oauth2.api.session.SessionClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
@Component
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SessionClient sessionClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws SystemException {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (null == authorization) {
            authorization = request.getParameter(HttpHeaders.AUTHORIZATION);
        }
        log.info("获取authorization信息:{}", authorization);
        if (authorization != null) {
            BaseResponse<SessionUser> baseResponse = sessionClient.getUserInfo(authorization);
            if (baseResponse.getCode() == BaseErrorCodeEnum.SUCCESS.getErrCode()) {
                SessionUser sessionUser = baseResponse.getData();
                if (sessionUser != null) {
                    SessionContext.getContext().set(Constants.Oauth.AUTHP_USER_AP_PREFIX, sessionUser);
                } else {
                    log.info("获取用户session信息---------------为null");
                    throw new SessionException(BaseErrorCodeEnum.ERROR_501);
                }
            } else {
                log.info("获取用户session信息---------------异常:{}", baseResponse.getMessage());
                throw new SessionException(BaseErrorCodeEnum.ERROR_501);
            }
        } else {
            log.info("获取authorization信息---------------为null");
        }
        return true;
    }

    /**
     * This implementation is empty.
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        SessionContext.removeContext();
    }
}