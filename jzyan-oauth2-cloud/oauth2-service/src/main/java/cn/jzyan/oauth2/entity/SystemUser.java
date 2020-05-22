package cn.jzyan.oauth2.entity;

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
@Entity
@Table(name = "system_user")
public class SystemUser{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String password;
    private String login;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "SystemUser{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
