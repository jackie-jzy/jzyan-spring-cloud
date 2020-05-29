package cn.jzyan.oauth2.api;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName : jzyan-oauth2-cloud
 * @FileName : FeignClientAutoConfiguration
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.api
 * @Description : 自动配置
 * @Author : jzyan
 * @CreateDate : 2020/04/24 15:43
 */
@Configuration
@EnableFeignClients(basePackages = "cn.jzyan.oauth2.api")
@ComponentScan(basePackages = "cn.jzyan.oauth2.api")
public class FeignClientAutoConfiguration {

}
