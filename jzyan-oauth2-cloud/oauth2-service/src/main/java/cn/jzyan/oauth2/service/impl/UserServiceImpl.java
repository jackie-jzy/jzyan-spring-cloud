package cn.jzyan.oauth2.service.impl;

import cn.jzyan.oauth2.entity.user.AdminUser;
import cn.jzyan.oauth2.repository.UserRepository;
import cn.jzyan.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : UserService
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.user
 * @Description : user
 * @Author : jzyan
 * @CreateDate : 2020/04/27 17:26
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser user = userRepository.findByUsername(username);
        if (user != null) {
            return new User(user.getUsername(), user.getPassword(), new HashSet<>());
        } else {
            throw new UsernameNotFoundException("用户不存在");
        }
    }

    @Override
    public AdminUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
