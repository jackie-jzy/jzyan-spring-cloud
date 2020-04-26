package cn.jzyan.ribbon;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.user.api.UserClient;
import cn.jzyan.user.bean.dto.UserDTO;
import cn.jzyan.user.bean.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName : jzyan-base-dependency
 * @FileName : UserRibbonController
 * @Version : 1.0.0
 * @Package : cn.jzyan.ribbon
 * @Description : user
 * @Author : jzyan
 * @CreateDate : 2020/03/26 14:39
 */
@RestController
@RequestMapping("/ribbon/user/")
public class UserRibbonController {

    @Autowired
    private UserClient userClient;

    @GetMapping("get")
    public BaseResponse<UserVO> get(@RequestParam Integer id) {
        return userClient.get(id);
    }

    @GetMapping("page")
    public BaseResponse<List<UserVO>> page(@RequestParam String name) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        return userClient.page(userDTO);
    }

}
