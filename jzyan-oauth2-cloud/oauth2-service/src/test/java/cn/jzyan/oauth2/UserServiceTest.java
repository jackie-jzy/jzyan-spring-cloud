package cn.jzyan.oauth2;

import cn.jzyan.oauth2.entity.SystemUser;
import cn.jzyan.oauth2.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ProjectName : jzyan-oauth2-cloud
 * @FileName : UserService
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.service
 * @Description : 用户
 * @Author : jzyan
 * @CreateDate : 2020/05/22 16:16
 */
public class UserServiceTest extends Oauth2ServiceApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void save() {
        SystemUser user = new SystemUser();
        for (int i = 0; i < 2; i++) {
            user.setPassword("123456");
            user.setUsername("andy" + i);
            userService.save(user);
        }
    }
}
