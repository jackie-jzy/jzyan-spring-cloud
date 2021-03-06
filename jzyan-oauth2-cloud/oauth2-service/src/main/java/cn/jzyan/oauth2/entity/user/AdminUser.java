package cn.jzyan.oauth2.entity.user;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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
public class AdminUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;
    private String username;
    private String name;
    private String mobile;
    private Integer status;
    private Integer mark;
    private Integer platform;
    private String createUser;
    private String updateUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
