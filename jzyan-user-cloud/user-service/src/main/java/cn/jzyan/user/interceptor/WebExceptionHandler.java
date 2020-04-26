package cn.jzyan.user.interceptor;

import cn.jzyan.user.constant.ErrorCodeEnum;
import cn.jzyan.user.model.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ProjectName : online-shop
 * @FileName : WebExceptionHandler
 * @Version : 1.0
 * @Package : com.juzifenqi.onadmin.interceptor
 * @Description : 统一异常处理
 * @Author : jzyan
 * @CreateDate : 2019/04/20 11:31
 * @ModificationHistory Who        When      What
 * --------- ---------     ---------------------------
 */
@Slf4j
@RestControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public RestResponse exception(Exception e) {
        log.error("未知异常:", e);
        return new RestResponse(ErrorCodeEnum.ERROR_300);
    }

}
