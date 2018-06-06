package x.demo.springboot.template.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld/v1")
@Slf4j
public class HelloWorldController {


    /**
     * 默认使用jackson 返回json
     *
     * @return 成功
     */
    @GetMapping("/say")
    public ResponseEntity<String> say() {
        ResponseEntity<String> result = ResponseEntity.ok("Success!");
        log.info("result : {} ", result);
        return result;
    }

}
