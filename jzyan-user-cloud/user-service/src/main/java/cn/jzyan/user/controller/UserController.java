package cn.jzyan.user.controller;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.user.bean.dto.UserDTO;
import cn.jzyan.user.bean.vo.UserVO;
import cn.jzyan.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName : jzyan-user-cloud
 * @FileName : UserController
 * @Version : 1.0.0
 * @Package : cn.jzyan.user.controller
 * @Description : user
 * @Author : jzyan
 * @CreateDate : 2020/03/26 14:11
 */
@RestController
@RequestMapping("/system/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("get")
    public BaseResponse<UserVO> get(@RequestParam Integer id) {
        return userService.get(id);
    }

    @PostMapping("page")
    public BaseResponse<List<UserVO>> page(@RequestBody UserDTO userDTO) {
        return userService.userDTO(userDTO);
    }

}
