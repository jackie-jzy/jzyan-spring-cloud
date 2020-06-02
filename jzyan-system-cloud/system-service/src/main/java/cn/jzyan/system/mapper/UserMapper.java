package cn.jzyan.system.mapper;

import cn.jzyan.system.bean.user.AdminUser;
import cn.jzyan.system.bean.user.dto.AdminUserDTO;
import cn.jzyan.system.bean.user.vo.AdminUserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : UserRepository
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.repository
 * @Description : 用户
 * @Author : jzyan
 * @CreateDate : 2020/05/15 10:21
 */
@Repository
public interface UserMapper extends BaseMapper<AdminUser> {

    IPage<AdminUserVO> adminPage(Page<?> page, @Param("user") AdminUserDTO adminUserDTO);

}
