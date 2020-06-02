package cn.jzyan.oauth2.api.session;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.bean.constant.BaseErrorCodeEnum;
import cn.jzyan.oauth2.bean.session.SessionUser;
import org.springframework.stereotype.Component;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : SessionClient
 * @Version : 1.0
 * @Package : cn.jzyan.oauth2.api.session
 * @Description : session
 * @Author : jzyan
 * @CreateDate : 2020/06/02 10:49
 */
@Component
public class SessionClientFallback implements SessionClient {

    @Override
    public BaseResponse<SessionUser> getUserInfo(String authorization) {
        return new BaseResponse<>(BaseErrorCodeEnum.FAIL);
    }
}
