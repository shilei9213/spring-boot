package x.demo.springboot.template.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication：springboot应用程序 1）扫描当前包及其子包
 */
@SpringBootApplication
public class SpringBootTemplateWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTemplateWebApplication.class, args);
    }

}
