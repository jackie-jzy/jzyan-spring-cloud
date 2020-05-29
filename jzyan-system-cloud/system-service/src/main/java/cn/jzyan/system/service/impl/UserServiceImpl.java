package cn.jzyan.system.service.impl;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.system.bean.constant.ErrorCodeEnum;
import cn.jzyan.system.bean.user.dto.UserDTO;
import cn.jzyan.system.bean.exception.UserException;
import cn.jzyan.system.bean.user.vo.UserVO;
import cn.jzyan.system.entity.RestResponse;
import cn.jzyan.system.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName : jzyan-system-cloud
 * @FileName : UserServiceImpl
 * @Version : 1.0.0
 * @Package : cn.jzyan.system.service.impl
 * @Description : user
 * @Author : jzyan
 * @CreateDate : 2020/03/26 14:13
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public BaseResponse<UserVO> get(Integer id) {
        if (id == 1) {
            throw new NullPointerException();
        }
        if (id == 2) {
            throw new UserException(ErrorCodeEnum.ERROR_500);
        }
        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setName("jzyan");
        userVO.setCreateTime(new Date());
        return new RestResponse(userVO);
    }

    @Override
    public BaseResponse<List<UserVO>> userDTO(UserDTO userDTO) {
        UserVO userVO = new UserVO();
        userVO.setId(1);
        userVO.setName(userDTO.getName());
        UserVO userVO2 = new UserVO();
        userVO2.setId(2);
        userVO2.setName(userDTO.getName());
        List<UserVO> list = new ArrayList<>(2);
        list.add(userVO);
        list.add(userVO2);
        return new RestResponse(list);
    }

}
