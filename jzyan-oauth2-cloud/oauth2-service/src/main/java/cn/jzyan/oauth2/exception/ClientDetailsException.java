package cn.jzyan.oauth2.exception;

import cn.jzyan.bean.exception.SystemException;
import cn.jzyan.oauth2.entity.ErrorCodeEnum;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : ClientDetailsException
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.exception
 * @Description : 认证客户端异常
 * @Author : jzyan
 * @CreateDate : 2020/05/25 12:05
 */
public class ClientDetailsException extends SystemException {
    public ClientDetailsException() {
        super();
    }

    public ClientDetailsException(String message) {
        super(message);
    }

    public ClientDetailsException(Integer code, String message) {
        super(code, message);
    }

    public ClientDetailsException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getErrCode(), errorCodeEnum.getErrMsg());
    }

    public ClientDetailsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientDetailsException(Integer code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
