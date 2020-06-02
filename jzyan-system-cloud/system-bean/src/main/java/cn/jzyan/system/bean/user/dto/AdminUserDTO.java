package cn.jzyan.system.bean.user.dto;

import cn.jzyan.bean.Page;
import cn.jzyan.system.bean.user.AdminUser;
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
public class AdminUserDTO extends AdminUser {

    private Page page = new Page();

}
