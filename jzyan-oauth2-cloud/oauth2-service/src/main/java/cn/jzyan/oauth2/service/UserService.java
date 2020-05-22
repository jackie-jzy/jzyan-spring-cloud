package cn.jzyan.oauth2.service;

import cn.jzyan.oauth2.entity.SystemUser;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : UserService
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.service
 * @Description : 用户
 * @Author : jzyan
 * @CreateDate : 2020/05/22 16:16
 */
public interface UserService {

    SystemUser save(SystemUser user);
}
