package cn.jzyan.oauth2.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : LoginVO
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.entity
 * @Description : 登录成功出参
 * @Author : jzyan
 * @CreateDate : 2020/05/23 16:11
 */
@Data
public class LoginResponse implements Serializable {

    private static final long serialVersionUID = 3079029293380111510L;

    /**
     * token
     */
    private String accessToken;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * token过期时间 seconds
     */
    private Integer expiresIn;

}
