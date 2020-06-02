package cn.jzyan.system;

import cn.jzyan.system.bean.client.ClientDetail;
import cn.jzyan.system.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : ClientServiceTest
 * @Version : 1.0
 * @Package : cn.jzyan.system
 * @Description : client
 * @Author : jzyan
 * @CreateDate : 2020/06/02 16:31
 */
public class ClientServiceTest extends SystemServiceApplicationTests {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClientService clientService;

    @Test
    public void saveTest() {
        ClientDetail clientDetail = new ClientDetail();
        clientDetail.setClientId("system_client");
        clientDetail.setClientSecret(passwordEncoder.encode("123456"));
        clientDetail.setAuthorizedGrantTypes("password,authorization_code,refresh_token");
        clientService.save(clientDetail);
    }
}
