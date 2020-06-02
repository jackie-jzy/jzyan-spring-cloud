package cn.jzyan.global.utils;

import cn.jzyan.bean.SessionUser;
import cn.jzyan.bean.constant.Constants;
import cn.jzyan.global.context.SessionContext;
import org.springframework.stereotype.Component;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : SessionUtil
 * @Version : 1.0
 * @Package : cn.jzyan.bean.utils
 * @Description : SessionUtil
 * @Author : jzyan
 * @CreateDate : 2020/06/02 15:52
 */
@Component
public class SessionUtil {

    /**
     * 获取登录用户信息
     *
     * @return
     */
    public SessionUser getUserInfo() {
        Object object = SessionContext.getContext().get(Constants.Oauth.AUTHP_USER_AP_PREFIX);
        if (object != null) {
            return (SessionUser) object;
        }
        return new SessionUser();
    }

    /**
     * 获取登录用户信息 登录账号
     *
     * @return
     */
    public String getUsername() {
        return getUserInfo().getUsername();
    }

    /**
     * 获取登录用户信息 姓名
     *
     * @return
     */
    public String getName() {
        return getUserInfo().getName();
    }

    /**
     * 获取登录用户信息 id
     *
     * @return
     */
    public Integer getUserId() {
        return getUserInfo().getId();
    }

    /**
     * 获取登录用户信息 手机号
     *
     * @return
     */
    public String getMobile() {
        return getUserInfo().getMobile();
    }
}
