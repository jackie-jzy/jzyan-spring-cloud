package cn.jzyan.system.bean.exception;

import cn.jzyan.bean.exception.SystemException;
import cn.jzyan.system.bean.constant.ErrorCodeEnum;

/**
 * @ProjectName : jzyan-system-cloud
 * @FileName : UserException
 * @Version : 1.0.0
 * @Package : cn.jzyan.system.bean.exception
 * @Description : 异常
 * @Author : jzyan
 * @CreateDate : 2020/04/27 14:55
 */
public class UserException extends SystemException {

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(Integer code, String message) {
        super(code, message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getErrCode(), errorCodeEnum.getErrMsg());
    }

    public UserException(ErrorCodeEnum errorCodeEnum, Throwable cause) {
        super(errorCodeEnum.getErrCode(), errorCodeEnum.getErrMsg(), cause);
    }

}
