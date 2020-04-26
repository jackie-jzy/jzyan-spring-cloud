package cn.jzyan.user.service;


import cn.jzyan.bean.BaseResponse;
import cn.jzyan.user.bean.dto.UserDTO;
import cn.jzyan.user.bean.vo.UserVO;

import java.util.List;

/**
 * @ProjectName : jzyan-user-cloud
 * @FileName : UserService
 * @Version : 1.0.0
 * @Package : cn.jzyan.user.service
 * @Description : user
 * @Author : jzyan
 * @CreateDate : 2020/03/26 14:12
 */
public interface UserService {

    BaseResponse<UserVO> get(Integer id);

    BaseResponse<List<UserVO>> userDTO(UserDTO userDTO);
}
