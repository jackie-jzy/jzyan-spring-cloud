package cn.jzyan.user.api;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName : jzyan-user-cloud
 * @FileName : FeignClientAutoConfiguration
 * @Version : 1.0.0
 * @Package : cn.jzyan.user.api
 * @Description : 自动配置
 * @Author : jzyan
 * @CreateDate : 2020/04/24 15:43
 */
@Configuration
@EnableFeignClients(basePackages = "cn.jzyan.user.api")
public class FeignClientAutoConfiguration {

}
