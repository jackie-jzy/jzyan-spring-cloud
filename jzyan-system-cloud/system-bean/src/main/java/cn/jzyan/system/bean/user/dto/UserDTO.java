package cn.jzyan.system.bean.user.dto;

import java.io.Serializable;

/**
 * @ProjectName : jzyan-system-cloud
 * @FileName : UserDTO
 * @Version : 1.0.0
 * @Package : cn.jzyan.system.bean.user.dto
 * @Description : user
 * @Author : jzyan
 * @CreateDate : 2020/04/24 14:57
 */
public class UserDTO implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
