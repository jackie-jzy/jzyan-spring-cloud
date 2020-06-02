package cn.jzyan.system.service;

import cn.jzyan.bean.BaseResponse;
import cn.jzyan.system.bean.client.ClientDetail;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : ClientService
 * @Version : 1.0
 * @Package : cn.jzyan.system.service
 * @Description : oauth2 client
 * @Author : jzyan
 * @CreateDate : 2020/06/02 16:21
 */
public interface ClientService {

    /**
     * 添加
     *
     * @param clientDetail
     * @return
     */
    BaseResponse save(ClientDetail clientDetail);
}
