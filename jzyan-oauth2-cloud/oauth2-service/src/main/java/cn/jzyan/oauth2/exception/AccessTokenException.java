package cn.jzyan.oauth2.exception;

import cn.jzyan.bean.exception.SystemException;
import cn.jzyan.oauth2.entity.ErrorCodeEnum;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : AccessTokenException
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.exception
 * @Description : Token异常
 * @Author : jzyan
 * @CreateDate : 2020/05/25 11:59
 */
public class AccessTokenException extends SystemException {

    public AccessTokenException() {
        super();
    }

    public AccessTokenException(String message) {
        super(message);
    }

    public AccessTokenException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getErrCode(), errorCodeEnum.getErrMsg());
    }

    public AccessTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessTokenException(ErrorCodeEnum errorCodeEnum, Throwable cause) {
        super(errorCodeEnum.getErrCode(), errorCodeEnum.getErrMsg(), cause);
    }
}
