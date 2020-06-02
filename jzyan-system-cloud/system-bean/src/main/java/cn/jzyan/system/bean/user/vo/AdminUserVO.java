package cn.jzyan.system.bean.user.vo;

import cn.jzyan.system.bean.user.AdminUserDO;
import lombok.Data;

/**
 * @ProjectName : jzyan-system-cloud
 * @FileName : AdminUserVO
 * @Version : 1.0.0
 * @Package : cn.jzyan.system.bean.user.vo
 * @Description : user
 * @Author : jzyan
 * @CreateDate : 2020/04/24 11:55
 */
@Data
public class AdminUserVO extends AdminUserDO {

    private String statusStr;
    private String platformStr;

}
