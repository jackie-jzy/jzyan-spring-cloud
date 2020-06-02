package cn.jzyan.oauth2.entity.user;

import cn.jzyan.oauth2.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : User
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.entity.user
 * @Description : 用户
 * @Author : jzyan
 * @CreateDate : 2020/05/22 15:34
 */
@Data
@Entity
@Table(name = "system_user")
public class AdminUser extends BaseEntity{

    private String password;
    private String username;
    private String name;
    private String mobile;
    private Integer status;
    private Integer mark;
    private Integer platform;

}
