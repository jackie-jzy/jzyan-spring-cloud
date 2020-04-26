package cn.jzyan.global.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ProjectName : jzyan-base-package
 * @FileName : FeignOkHttpProoerties
 * @Version : 1.0.0
 * @Package : cn.jzyan.global.properties
 * @Description : FeignOkHttpProoerties
 * @Author : jzyan
 * @CreateDate : 2020/04/24 16:35
 */
@ConfigurationProperties(prefix = FeignOkHttpProperties.FEIGN_PREFIX)
public class FeignOkHttpProperties {

    public static final String FEIGN_PREFIX = "feign.okhttp";

    private long readTimeout = 5000;
    private long connectTimeout = 3000;
    private long writeTimeout = 5000;
    private int maxIdleConnections = 5;
    private long keepAliveDuration = 5;

    public long getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
    }

    public long getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public long getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(long writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    public int getMaxIdleConnections() {
        return maxIdleConnections;
    }

    public void setMaxIdleConnections(int maxIdleConnections) {
        this.maxIdleConnections = maxIdleConnections;
    }

    public long getKeepAliveDuration() {
        return keepAliveDuration;
    }

    public void setKeepAliveDuration(long keepAliveDuration) {
        this.keepAliveDuration = keepAliveDuration;
    }

    @Override
    public String toString() {
        return "FeignOkHttpProperties{" +
                "readTimeout=" + readTimeout +
                ", connectTimeout=" + connectTimeout +
                ", writeTimeout=" + writeTimeout +
                ", maxIdleConnections=" + maxIdleConnections +
                ", keepAliveDuration=" + keepAliveDuration +
                '}';
    }
}
