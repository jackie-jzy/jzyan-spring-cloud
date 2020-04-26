package cn.jzyan.bean;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ProjectName : online-shop
 * @FileName : CustomerBigDecimalSerialize
 * @Version : 1.0
 * @Package : com.juzifenqi.onweb.config
 * @Description : 自定义 BigDecimal处理
 * @Author : jzyan
 * @CreateDate : 2020/04/10 14:28
 */
public class CustomerBigDecimalSerialize extends JsonSerializer<BigDecimal> {
    /**
     * Method that can be called to ask implementation to serialize
     * values of type this serializer handles.
     *
     * @param value       Value to serialize; can <b>not</b> be null.
     * @param gen         Generator used to output resulting Json content
     * @param serializers Provider that can be used to get serializers for
     */
    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            gen.writeString(String.valueOf(value.setScale(2, RoundingMode.HALF_UP)));
        }
    }
}
