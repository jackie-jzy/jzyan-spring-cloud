package cn.jzyan.system;

import cn.jzyan.system.bean.user.dto.AdminUserDTO;
import cn.jzyan.system.service.UserService;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : UserServiceTest
 * @Version : 1.0
 * @Package : cn.jzyan.system
 * @Description : user
 * @Author : jzyan
 * @CreateDate : 2020/06/02 14:20
 */
public class UserServiceTest extends SystemServiceApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void pageTest() {
        AdminUserDTO adminUserDTO = new AdminUserDTO();
        System.out.println(JSON.toJSONString(userService.adminPage(adminUserDTO)));
    }
}
