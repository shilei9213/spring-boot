package x.demo.springboot.starter.hw.autoconfiguration;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 用于springboot 从配置文件 （application.yml） 中读取 helloworld配置
 */
@ConfigurationProperties(prefix = HelloWorldProperties.HELLOWORLD_PREFIX)
public class HelloWorldProperties {

    public static final String HELLOWORLD_PREFIX = "helloworld";

    private Map<String, Object> author;

    public Map<String, Object> getAuthor() {
        return author;
    }

    public void setAuthor(Map<String, Object> author) {
        this.author = author;
    }
}
