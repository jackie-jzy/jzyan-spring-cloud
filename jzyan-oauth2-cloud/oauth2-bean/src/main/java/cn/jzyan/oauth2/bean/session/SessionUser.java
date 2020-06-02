package cn.jzyan.oauth2.bean.session;

import cn.jzyan.bean.BaseEntity;
import lombok.Data;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : User
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.model
 * @Description : 用户
 * @Author : jzyan
 * @CreateDate : 2020/05/22 15:34
 */
@Data
public class SessionUser extends BaseEntity {

    private static final long serialVersionUID = 5191122480495767646L;

    private String password;
    private String username;
    private String name;
    private String mobile;
    private Integer status;
    private Integer mark;
    private Integer platform;

}
