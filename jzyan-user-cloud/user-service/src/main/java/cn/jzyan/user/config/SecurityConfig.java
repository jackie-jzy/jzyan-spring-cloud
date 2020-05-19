package cn.jzyan.user.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : SecurityConfig
 * @Version : 1.0.0
 * @Package : cn.jzyan.user.config
 * @Description : 安全配置
 * @Author : jzyan
 * @CreateDate : 2020/05/12 14:06
 */
@Configuration
@EnableOAuth2Sso
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().csrf().disable();
    }

}
