package cn.jzyan.oauth2.entity;

import lombok.Data;

import javax.persistence.*;

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
@Entity
@Table(name = "system_user")
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;
    private String username;
    private String name;
    private String mobile;

}
