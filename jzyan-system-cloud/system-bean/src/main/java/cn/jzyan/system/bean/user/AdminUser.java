package cn.jzyan.system.bean.user;

import cn.jzyan.bean.BaseEntity;
import lombok.Data;

/**
 * @ProjectName : jzyan-system-cloud
 * @FileName : AdminUserDTO
 * @Version : 1.0.0
 * @Package : cn.jzyan.system.bean.user.dto
 * @Description : user
 * @Author : jzyan
 * @CreateDate : 2020/04/24 14:57
 */
@Data
public class AdminUser extends BaseEntity {

    private String username;
    private String mobile;
    private Integer status;
    private Integer platform;

}
