package cn.jzyan.bean.exception;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : SystemException
 * @Version : 1.0.0
 * @Package : cn.jzyan.user.bean.exception
 * @Description : 系统异常基类
 * @Author : jzyan
 * @CreateDate : 2020/04/27 15:07
 */
public class SystemException extends RuntimeException {

    private Integer code;

    public SystemException() {
        super();
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}
