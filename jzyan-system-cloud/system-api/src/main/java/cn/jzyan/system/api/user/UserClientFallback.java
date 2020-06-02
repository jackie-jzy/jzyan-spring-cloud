package cn.jzyan.system.api.user;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.bean.constant.BaseErrorCodeEnum;
import cn.jzyan.system.bean.user.dto.AdminUserDTO;
import cn.jzyan.system.bean.user.vo.AdminUserVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName : jzyan-system-cloud
 * @FileName : UserClientFallback
 * @Version : 1.0.0
 * @Package : cn.jzyan.system.api.user
 * @Description : 服务异常处理类
 * @Author : jzyan
 * @CreateDate : 2020/04/27 13:35
 */
@Component
public class UserClientFallback implements UserClient {


    @Override
    public BaseResponse<AdminUserVO> get(Integer id) {
        return new BaseResponse<>(BaseErrorCodeEnum.FAIL);
    }

    @Override
    public BaseResponse<List<AdminUserVO>> page(AdminUserDTO userDTO) {
        return new BaseResponse<>(BaseErrorCodeEnum.FAIL);
    }

}
