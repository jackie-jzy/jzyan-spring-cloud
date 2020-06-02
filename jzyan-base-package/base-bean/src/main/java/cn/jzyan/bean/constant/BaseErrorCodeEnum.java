package cn.jzyan.bean.constant;

/**
 * @ProjectName : jzyan-base-package
 * @FileName : ErrorCodeEnum
 * @Version : 1.0.0
 * @Package : cn.jzyan.bean
 * @Description : 统一返回码
 * @Author : jzyan
 * @CreateDate : 2019/04/17 20:47
 */
public enum BaseErrorCodeEnum {

    SUCCESS(200, "SUCCESS"),
    FAIL(500, "服务器异常"),
    ERROR_501(501, "获取session异常"),
    ERROR_502(502, "获取authorization异常");

    private int errCode;
    private String errMsg;

    BaseErrorCodeEnum(int errCode, String errMsg) {
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
