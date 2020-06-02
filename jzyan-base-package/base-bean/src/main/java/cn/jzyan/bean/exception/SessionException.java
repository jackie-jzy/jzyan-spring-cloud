package cn.jzyan.bean.exception;

import cn.jzyan.bean.constant.BaseErrorCodeEnum;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : SessionException
 * @Version : 1.0
 * @Package : cn.jzyan.bean.exception
 * @Description : session异常
 * @Author : jzyan
 * @CreateDate : 2020/06/02 15:43
 */
public class SessionException extends SystemException {

    public SessionException() {
        super();
    }

    public SessionException(String message) {
        super(message);
    }

    public SessionException(Integer code, String message) {
        super(code, message);
    }

    public SessionException(BaseErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getErrCode(), errorCodeEnum.getErrMsg());
    }

    public SessionException(String message, Throwable cause) {
        super(message, cause);
    }

    public SessionException(Integer code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
