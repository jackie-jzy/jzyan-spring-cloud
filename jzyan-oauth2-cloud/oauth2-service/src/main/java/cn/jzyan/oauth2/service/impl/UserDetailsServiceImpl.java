package cn.jzyan.oauth2.service.impl;

import cn.jzyan.oauth2.entity.User;
import cn.jzyan.oauth2.repository.UserRepository;
import cn.jzyan.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : UserService
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.user
 * @Description : user
 * @Author : jzyan
 * @CreateDate : 2020/04/27 17:26
 */
@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("用户不存在");
        }
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


}
