package cn.jzyan.system.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName : jzyan-system-package
 * @FileName : WebConfigurer
 * @Version : 1.0.0
 * @Package : cn.jzyan.system.interceptor
 * @Description : WebConfigurer
 * @Author : jzyan
 * @CreateDate : 2020/04/24 14:09
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private AuthorityInterceptor authorityInterceptor;

    /**
     * 这个方法是用来配置静态资源的，比如html，js，css，等等
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    /**
     * 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor).addPathPatterns("/**");
    }
}
