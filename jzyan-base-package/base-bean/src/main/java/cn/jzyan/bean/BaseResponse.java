package cn.jzyan.bean;


import cn.jzyan.bean.constant.BaseErrorCodeEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ProjectName : jzyan-base-package
 * @FileName : RestResponse
 * @Version : 1.0
 * @Package : cn.jzyan.bean
 * @Description : 接口统一出参
 * @Author : jzyan
 * @CreateDate : 2020/02/04 14:23
 * @ModificationHistory Who        When      What
 * --------- ---------     ---------------------------
 */
@Setter
@Getter
public class BaseResponse<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public BaseResponse() {
        this.code = BaseErrorCodeEnum.SUCCESS.getErrCode();
        this.message = BaseErrorCodeEnum.SUCCESS.getErrMsg();
    }

    public BaseResponse(BaseErrorCodeEnum baseErrorCodeEnum) {
        this.code = baseErrorCodeEnum.getErrCode();
        this.message = baseErrorCodeEnum.getErrMsg();
    }

    public BaseResponse(T data) {
        this.data = data;
        this.code = BaseErrorCodeEnum.SUCCESS.getErrCode();
        this.message = BaseErrorCodeEnum.SUCCESS.getErrMsg();
    }

    public BaseResponse(T data, Integer code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

}
