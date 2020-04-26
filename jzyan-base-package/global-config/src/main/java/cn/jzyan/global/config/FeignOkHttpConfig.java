package cn.jzyan.global.config;

import cn.jzyan.global.properties.FeignOkHttpProperties;
import feign.Feign;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName : jzyan-base-package
 * @FileName : FeignOkHttpConfig
 * @Version : 1.0.0
 * @Package : cn.jzyan.global.config
 * @Description : FeignOkHttpConfig
 * @Author : jzyan
 * @CreateDate : 2020/04/24 14:09
 */
@Slf4j
@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
@EnableConfigurationProperties(FeignOkHttpProperties.class)
public class FeignOkHttpConfig {

    @Autowired
    private FeignOkHttpProperties feignOkHttpProperties;

    @Bean
    public okhttp3.OkHttpClient okHttpClient() {
        log.info("初始化okhttp3客户端属性配置---------------------{}", feignOkHttpProperties.toString());
        return new okhttp3.OkHttpClient.Builder()
                .readTimeout(feignOkHttpProperties.getReadTimeout(), TimeUnit.MILLISECONDS)
                .connectTimeout(feignOkHttpProperties.getConnectTimeout(), TimeUnit.MILLISECONDS)
                .writeTimeout(feignOkHttpProperties.getWriteTimeout(), TimeUnit.MILLISECONDS)
                .connectionPool(new ConnectionPool(feignOkHttpProperties.getMaxIdleConnections()
                        , feignOkHttpProperties.getKeepAliveDuration(), TimeUnit.MINUTES))
                .build();
    }

}
