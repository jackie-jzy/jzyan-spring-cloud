package cn.jzyan.system.api;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName : jzyan-system-cloud
 * @FileName : FeignClientAutoConfiguration
 * @Version : 1.0.0
 * @Package : cn.jzyan.system.api
 * @Description : 自动配置
 * @Author : jzyan
 * @CreateDate : 2020/04/24 15:43
 */
@Configuration
@EnableFeignClients(basePackages = "cn.jzyan.system.api")
@ComponentScan(basePackages = "cn.jzyan.system.api")
public class FeignClientAutoConfiguration {

}
