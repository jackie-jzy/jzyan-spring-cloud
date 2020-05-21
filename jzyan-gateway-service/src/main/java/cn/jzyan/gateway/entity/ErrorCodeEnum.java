package cn.jzyan.gateway.entity;

/**
 * @ProjectName : jzyan-base-package
 * @FileName : ErrorCodeEnum
 * @Version : 1.0.0
 * @Package : cn.jzyan.bean
 * @Description : 统一返回码
 * @Author : jzyan
 * @CreateDate : 2019/04/17 20:47
 */
public enum ErrorCodeEnum {

    ERROR_401(401, "invalid access token,please check"),
    ERROR_402(402, "access token has expired,please reacquire token");

    private int errCode;
    private String errMsg;

    ErrorCodeEnum(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
