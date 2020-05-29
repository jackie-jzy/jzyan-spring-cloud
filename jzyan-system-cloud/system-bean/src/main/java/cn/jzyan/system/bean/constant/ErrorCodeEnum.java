package cn.jzyan.system.bean.constant;

/**
 * @ProjectName : jzyan-system-cloud
 * @FileName : ErrorCodeEnum
 * @Version : 1.0.0
 * @Package : cn.jzyan.system.constant
 * @Description : 统一返回码
 * @Author : jzyan
 * @CreateDate : 2019/04/17 20:47
 */
public enum ErrorCodeEnum {

    ERROR_500(500, "系统异常");

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
