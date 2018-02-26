package x.demo.springboot.web.controller;


import javax.annotation.Resource;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import x.demo.springboot.starter.hw.HelloWorldTemplate;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldContorller {

    @Resource
    HelloWorldTemplate helloWorldTemplate;

    @GetMapping("/say")
    public String say() {
        String message = helloWorldTemplate.generate("------------");
        return StringUtils.replace(message,"\n","<br/>");
    }
}
