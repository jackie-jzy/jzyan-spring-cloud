package cn.jzyan.user.interceptor;

import cn.jzyan.user.bean.constant.ErrorCodeEnum;
import cn.jzyan.user.bean.exception.SystemException;
import cn.jzyan.user.model.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ProjectName : jzyan-user-cloud
 * @FileName : WebExceptionHandler
 * @Version : 1.0.0
 * @Package : cn.jzyan.user.interceptor
 * @Description : 统一异常处理
 * @Author : jzyan
 * @CreateDate : 2019/04/20 11:31
 */
@Slf4j
@RestControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(value = SystemException.class)
    public RestResponse systemException(SystemException e) {
        log.error("系统异常:", e);
        return new RestResponse(ErrorCodeEnum.ERROR_300);
    }

}
