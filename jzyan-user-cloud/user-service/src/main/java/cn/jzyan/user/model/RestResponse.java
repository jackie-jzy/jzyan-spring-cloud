package cn.jzyan.user.model;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.user.constant.ErrorCodeEnum;

/**
 * @ProjectName : jzyan-base-dependency
 * @FileName : RestResponse
 * @Version : 1.0.0
 * @Package : cn.jzyan.user.model
 * @Description : 统一返回
 * @Author : jzyan
 * @CreateDate : 2020/04/22 15:43
 */
public class RestResponse<T> extends BaseResponse {

    public RestResponse() {
        super();
    }

    public RestResponse(T data) {
        super(data);
    }

    public RestResponse(ErrorCodeEnum ErrorCodeEnum) {
        super(null, ErrorCodeEnum.getErrCode(), ErrorCodeEnum.getErrMsg());
    }

    public RestResponse(T data, ErrorCodeEnum ErrorCodeEnum) {
        super(data, ErrorCodeEnum.getErrCode(), ErrorCodeEnum.getErrMsg());
    }

    public RestResponse(T data, Integer code, String message) {
        super(data, code, message);
    }

}
