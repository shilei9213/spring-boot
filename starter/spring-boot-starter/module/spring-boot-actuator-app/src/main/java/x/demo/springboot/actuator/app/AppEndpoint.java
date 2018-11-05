package x.demo.springboot.actuator.app;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;

/**
 * @author shilei0907
 * @version 1.0, 2018/10/31
 */
@Endpoint(id = "app")
public class AppEndpoint {
    App app = new App("actuator-test", "ios");

    @ReadOperation
    public App read() {
        return app;
    }

    @WriteOperation
    public String write(String name, String platform) {
        app.setName(name);
        app.setPlatform(platform);
        return "success";
    }
}
