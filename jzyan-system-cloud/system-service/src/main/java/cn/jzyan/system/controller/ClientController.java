package cn.jzyan.system.controller;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.system.bean.client.ClientDetail;
import cn.jzyan.system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName : jzyan-system-cloud
 * @FileName : ClientController
 * @Version : 1.0.0
 * @Package : cn.jzyan.system.controller
 * @Description : client
 * @Author : jzyan
 * @CreateDate : 2020/03/26 14:11
 */
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/save")
    public BaseResponse save(@RequestBody ClientDetail clientDetail) {
        return clientService.save(clientDetail);
    }

}
