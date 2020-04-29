package cn.jzyan.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : ResourceServerConfig
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.config
 * @Description : 资源服务器配置
 * @Author : jzyan
 * @CreateDate : 2020/04/27 17:37
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .requestMatchers()
                // 配置需要保护的资源路径
                .antMatchers("/user/**");
    }

}
