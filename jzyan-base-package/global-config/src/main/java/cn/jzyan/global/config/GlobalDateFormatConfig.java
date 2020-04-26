package cn.jzyan.global.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName : jzyan-base-package
 * @FileName : GlobalDateFormatConfig
 * @Version : 1.0.0
 * @Package : cn.jzyan.global.config
 * @Description : 全局日期格式化
 * @Author : jzyan
 * @CreateDate : 2019/05/14 15:50
 */
@Configuration
public class GlobalDateFormatConfig {

    /**
     * 获取日期格式化的工具类
     */
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") {

        //根据实际业务支持各种复杂格式的日期字符串。
        @Override
        public Date parse(String source) {
            try {
                //支持解析指定pattern类型。
                return super.parse(source);
            } catch (Exception e) {
                try {
                    //支持解析long类型的时间戳
                    return new StdDateFormat().parse(source);
                } catch (ParseException e1) {
                    throw new RuntimeException("日期格式非法：" + e);
                }
            }
        }
    };


    /**
     * JSON消息处理器
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        //设置解析JSON工具类
        ObjectMapper objectMapper = new ObjectMapper();
        //设置解析日期的工具类
        objectMapper.setDateFormat(dateFormat);
        //忽略未知属性 防止解析报错
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jsonConverter.setObjectMapper(objectMapper);
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON);
        jsonConverter.setSupportedMediaTypes(list);
        return jsonConverter;
    }

}
