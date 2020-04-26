package cn.jzyan.eurekasecurityserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ProjectName : jzyan-base-dependency
 * @FileName : WebSecurityConfig
 * @Version : 1.0
 * @Package : com.jzyan.eurekasecurityserver
 * @Description : 关闭csrf
 * @Author : jzyan
 * @CreateDate : 2020/03/23 11:38
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}
