package cn.jzyan.ribbon.api;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName : jzyan-base-package
 * @FileName : GlobalAutoConfiguration
 * @Version : 1.0.0
 * @Package : cn.jzyan.global
 * @Description : 自动配置
 * @Author : jzyan
 * @CreateDate : 2020/04/24 15:43
 */
@Configuration
@EnableFeignClients(basePackages = "cn.jzyan.ribbon.api")
public class FeignClientAutoConfiguration {

}
