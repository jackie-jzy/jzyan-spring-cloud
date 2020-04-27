package cn.jzyan.user.service.impl;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.user.bean.constant.ErrorCodeEnum;
import cn.jzyan.user.bean.dto.UserDTO;
import cn.jzyan.user.bean.exception.UserException;
import cn.jzyan.user.bean.vo.UserVO;
import cn.jzyan.user.model.RestResponse;
import cn.jzyan.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName : jzyan-user-cloud
 * @FileName : UserServiceImpl
 * @Version : 1.0.0
 * @Package : cn.jzyan.user.service.impl
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
            throw new UserException(ErrorCodeEnum.ERROR_300);
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
