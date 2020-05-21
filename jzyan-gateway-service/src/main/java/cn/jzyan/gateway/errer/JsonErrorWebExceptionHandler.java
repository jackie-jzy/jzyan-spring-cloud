package cn.jzyan.gateway.errer;

import cn.jzyan.bean.exception.SystemException;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.web.reactive.function.server.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : JsonErrorWebExceptionHandler
 * @Version : 1.0.0
 * @Package : cn.jzyan.gateway.errer
 * @Description : 统一异常返回处理器
 * @Author : jzyan
 * @CreateDate : 2020/05/21 14:01
 */
public class JsonErrorWebExceptionHandler extends DefaultErrorWebExceptionHandler {

    public JsonErrorWebExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ErrorProperties errorProperties, ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
    }

    @Override
    protected Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
        Throwable error = super.getError(request);
        Map<String, Object> errorAttributes = new HashMap<>(8);
        errorAttributes.put("message", error.getMessage());
        errorAttributes.put("data", null);
        if (error instanceof InvalidTokenException) {
            InvalidTokenException e = (InvalidTokenException) error;
            errorAttributes.put("code", e.getHttpErrorCode());
        } else if (error instanceof SystemException) {
            SystemException e = (SystemException) error;
            errorAttributes.put("code", e.getCode());
        } else {
            errorAttributes.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return errorAttributes;
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }

    @Override
    protected int getHttpStatus(Map<String, Object> errorAttributes) {
        return (Integer) errorAttributes.get("code");
    }

}
