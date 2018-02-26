package x.demo.springboot.starter.hw.autoconfiguration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import x.demo.springboot.starter.hw.HelloWorldTemplate;
import x.demo.springboot.starter.hw.outputformater.OutputFormater;


@EnableConfigurationProperties(HelloWorldProperties.class)
@Import(OutputFormaterAutoConfiguration.class)
@Configuration
public class HelloWorldAutoConfiguration {

    @Bean
    public HelloWorldTemplate helloWorldTemplate(HelloWorldProperties helloWorldProperties, OutputFormater outputFormater) {
        return new HelloWorldTemplate(helloWorldProperties, outputFormater);
    }
}
