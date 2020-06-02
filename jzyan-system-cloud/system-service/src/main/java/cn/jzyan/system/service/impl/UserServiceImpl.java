package cn.jzyan.system.service.impl;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.global.utils.SessionUtil;
import cn.jzyan.system.bean.user.dto.AdminUserDTO;
import cn.jzyan.system.bean.user.vo.AdminUserVO;
import cn.jzyan.system.entity.RestResponse;
import cn.jzyan.system.mapper.UserMapper;
import cn.jzyan.system.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SessionUtil sessionUtil;

    /**
     * 分页
     *
     * @param adminUserDTO
     * @return
     */
    @Override
    public BaseResponse<AdminUserVO> adminPage(AdminUserDTO adminUserDTO) {
        Page page = new Page(adminUserDTO.getPage().getPageNum(), adminUserDTO.getPage().getPageSize());
        IPage<AdminUserVO> content = userMapper.adminPage(page, adminUserDTO);
        return new RestResponse(content);
    }

}
