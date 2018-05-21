package x.demo.springboot.template.web.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * WebMvcConfig
 *
 * @author shilei0907
 * @version 1.0, 2018/5/20
 */
@Configuration
public class WebMvcConfig {


    /**
     * mvc 返回值替换jsckson为fastjson
     *
     * @return SpringMVC HttpMessageConverters
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        //创建converter实例
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //添加配置信息：如是否格式化
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);

        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
    }
}
