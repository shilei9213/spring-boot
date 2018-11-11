package x.demo.springboot.actuator.health;

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

/**
 * AppHealthIndicatorConfiguration
 *
 * @author shilei0907
 * @version 1.0, 2018/11/5
 */
@Configuration
public class AppHealthIndicatorConfiguration {

    // 指定名字
    @Bean("app-state")
    AppHealthIndicator appHealthIndicator() {
        return new AppHealthIndicator();
    }

    @Bean("app-state-extra")
    AppExtraHealthIndicator appExtraHealthIndicator() {
        return new AppExtraHealthIndicator();
    }
}
