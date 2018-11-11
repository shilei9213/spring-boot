package x.demo.springboot.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * AppExtraHealthIndicator
 *
 * @author shilei0907
 * @version 1.0, 2018/11/5
 */
@Component("app-extra")
public class AppExtraHealthIndicator extends AbstractHealthIndicator {

    /**
     * Actual health check logic.
     *
     * @param builder the {@link Builder} to report health status and details
     * @throws Exception any {@link Exception} that should create a {@link Status#DOWN}
     *                   system status.
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // 如果不正常，抛异常接口，AbstractHealthIndicator 完成异常捕获，down
        builder.up().withDetail("app-extra", "app-extra");
    }
}
