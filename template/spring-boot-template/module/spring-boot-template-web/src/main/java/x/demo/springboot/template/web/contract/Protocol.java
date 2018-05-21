package x.demo.springboot.template.web.contract;

import java.time.LocalDateTime;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.ToString;

/**
 * 协议
 *
 * @author shilei0907
 * @version 1.0, 2018/5/20
 */
@Getter
@ToString
public class Protocol<T> {
    private int returnCode;
    private String message;
    private T body;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time = LocalDateTime.now();

    public Protocol(int returnCode, String message) {
        this.returnCode = returnCode;
        this.message = message;
    }

    public Protocol(int returnCode, String message, T body) {
        this.returnCode = returnCode;
        this.message = message;
        this.body = body;
    }

}
