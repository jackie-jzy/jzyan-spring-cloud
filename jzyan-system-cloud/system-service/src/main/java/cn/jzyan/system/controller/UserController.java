package cn.jzyan.system.controller;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.system.bean.user.dto.AdminUserDTO;
import cn.jzyan.system.bean.user.vo.AdminUserVO;
import cn.jzyan.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName : jzyan-system-cloud
 * @FileName : UserController
 * @Version : 1.0.0
 * @Package : cn.jzyan.system.controller
 * @Description : user
 * @Author : jzyan
 * @CreateDate : 2020/03/26 14:11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/admin/page")
    public BaseResponse<AdminUserVO> adminPage(@RequestBody AdminUserDTO adminUserDTO) {
        return userService.adminPage(adminUserDTO);
    }

}
