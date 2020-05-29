package cn.jzyan.system.bean.user.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName : jzyan-system-cloud
 * @FileName : UserVO
 * @Version : 1.0.0
 * @Package : cn.jzyan.system.bean.user.vo
 * @Description : user
 * @Author : jzyan
 * @CreateDate : 2020/04/24 11:55
 */
public class UserVO implements Serializable {

    private Integer id;
    private String name;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
