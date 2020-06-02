package cn.jzyan.system.service.impl;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.system.bean.client.ClientDetail;
import cn.jzyan.system.entity.RestResponse;
import cn.jzyan.system.mapper.ClientMapper;
import cn.jzyan.system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : ClientServiceImpl
 * @Version : 1.0
 * @Package : cn.jzyan.system.service.impl
 * @Description : oauth2 client
 * @Author : jzyan
 * @CreateDate : 2020/06/02 16:22
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientMapper clientMapper;

    /**
     * 添加
     *
     * @param clientDetail
     * @return
     */
    @Override
    public BaseResponse save(ClientDetail clientDetail) {
        clientMapper.insert(clientDetail);
        return new RestResponse();
    }
}
