package cn.jzyan.oauth2.entity;

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

    ERROR_601(601, "账户或密码错误"),
    ERROR_602(602, "创建Token异常"),
    ERROR_603(603, "获取认证客户端为null");

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
