package cn.jzyan.system.service;


import cn.jzyan.bean.BaseResponse;
import cn.jzyan.system.bean.user.dto.AdminUserDTO;
import cn.jzyan.system.bean.user.vo.AdminUserVO;

/**
 * @ProjectName : jzyan-system-cloud
 * @FileName : UserService
 * @Version : 1.0.0
 * @Package : cn.jzyan.system.service
 * @Description : user
 * @Author : jzyan
 * @CreateDate : 2020/03/26 14:12
 */
public interface UserService {

    /**
     * 分页
     *
     * @param adminUserDTO
     * @return
     */
    BaseResponse<AdminUserVO> adminPage(AdminUserDTO adminUserDTO);
}
