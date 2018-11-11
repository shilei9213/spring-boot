package x.demo.springboot.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * AppHealthIndicator
 *
 * @author shilei0907
 * @version 1.0, 2018/11/5
 */
@Component("app")
public class AppHealthIndicator implements HealthIndicator {

    /**
     * Return an indication of health.
     *
     * @return the health for
     */
    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0) {
            // 状态不正常
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        // 健康
        return Health.up().build();
    }

    private int check() {
        return -1;
    }
}
