package cn.jzyan.oauth2.error;

import cn.jzyan.oauth2.exception.CustomOauth2Exception;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : CustomOauth2ExceptionJacksonSerializer
 * @Version : 1.0.0
 * @Package : cn.jzyan.oauth2.exception
 * @Description : 异常序列化
 * @Author : jzyan
 * @CreateDate : 2020/05/23 11:11
 */
public class CustomOauth2ExceptionJacksonSerializer extends StdSerializer<CustomOauth2Exception> {

    protected CustomOauth2ExceptionJacksonSerializer() {
        super(CustomOauth2Exception.class);
    }

    @Override
    public void serialize(CustomOauth2Exception value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("code", value.getHttpErrorCode());
        String errorMessage = value.getLocalizedMessage();
        String error = value.getOAuth2ErrorCode();
        if (errorMessage != null) {
            errorMessage = HtmlUtils.htmlEscape(errorMessage);
        }
        if (error != null) {
            error = HtmlUtils.htmlEscape(error);
        }
        gen.writeStringField("error", error);
        gen.writeStringField("msg", errorMessage);
        gen.writeStringField("data", null);
        if (value.getAdditionalInformation() != null) {
            for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
                String key = entry.getKey();
                String add = entry.getValue();
                gen.writeStringField(key, add);
            }
        }
        gen.writeEndObject();
    }
}
