package cn.jzyan.system.bean.user;

import lombok.Data;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : AdminUserDO
 * @Version : 1.0
 * @Package : cn.jzyan.system.bean.user
 * @Description : 系统用户
 * @Author : jzyan
 * @CreateDate : 2020/06/02 13:34
 */
@Data
public class AdminUserDO extends AdminUser {

    private String password;
    private Integer mark;

}
