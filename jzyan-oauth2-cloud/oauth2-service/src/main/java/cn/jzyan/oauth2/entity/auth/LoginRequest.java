package cn.jzyan.oauth2.entity.auth;

import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : LoginRequest
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.entity.auth
 * @Description : 登录入参
 * @Author : jzyan
 * @CreateDate : 2020/05/23 15:54
 */
@Data
public class LoginRequest implements Serializable {

    private static final long serialVersionUID = 833362591164870011L;

    private String username;
    private String password;
    /**
     * 验证码
     */
    private String code;
    /**
     * code key
     */
    private String codeKey;
    /**
     * 登录账号类型 0-账户 1-手机号 2-邮箱
     */
    private Integer accountType;

}
