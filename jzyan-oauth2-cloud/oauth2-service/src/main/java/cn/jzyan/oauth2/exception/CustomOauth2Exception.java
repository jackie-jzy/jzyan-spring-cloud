package cn.jzyan.oauth2.exception;

import cn.jzyan.oauth2.errer.CustomOauth2ExceptionJacksonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : UserException
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.exception
 * @Description : 认证用户异常
 * @Author : jzyan
 * @CreateDate : 2020/05/23 10:32
 */
@JsonSerialize(using = CustomOauth2ExceptionJacksonSerializer.class)
public class CustomOauth2Exception extends OAuth2Exception {

    public CustomOauth2Exception(String msg) {
        super(msg);
    }

    public CustomOauth2Exception(String msg, Throwable t) {
        super(msg, t);
    }
}
