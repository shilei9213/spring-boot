package x.demo.springboot.starter.hw.autoconfiguration;

import com.thoughtworks.xstream.XStream;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import x.demo.springboot.starter.hw.outputformater.FastJsonOutputFormater;
import x.demo.springboot.starter.hw.outputformater.OutputFormater;
import x.demo.springboot.starter.hw.outputformater.ToStringOutputFormater;
import x.demo.springboot.starter.hw.outputformater.XStreamOutputFormater;

@Configuration
public class OutputFormaterAutoConfiguration {

    /**
     * @ConditionalOnClass(name = "com.alibaba.fastjson.JSON") classpath 中有com.alibaba.fastjson.JSON 实例化 FastJsonOutputFormater
     */
    @ConditionalOnClass(name = "com.alibaba.fastjson.JSON")
    @Bean
    public OutputFormater fastJsonOutputFormater() {
        return new FastJsonOutputFormater();
    }


    @ConditionalOnClass(XStream.class)
    @Bean
    public XStream xStream() {
        return new XStream();
    }

    /**
     *  @ConditionalOnBean(XStream.class) 容器中存在xStream对象时使用, 特别注意，上面的XStream创建必须在前面
     */
    @ConditionalOnBean(XStream.class)
    @Bean
    public OutputFormater xStreamOutputFormater(XStream xStream) {
        return new XStreamOutputFormater(xStream);
    }




    /**
     * @ConditionalOnMissingClass ： classpath 中没有com.alibaba.fastjson.JSON 实例化，创建ToStringOutputFormater
     */
    @ConditionalOnMissingBean
    @Bean
    public OutputFormater toStringOutputFormater() {
        return new ToStringOutputFormater();
    }

}
