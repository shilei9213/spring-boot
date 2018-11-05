package x.demo.springboot.actuator.app;

import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppEndpointAutoConfiguration
 *
 * @author shilei0907
 * @version 1.0, 2018/11/5
 */
@Configuration
public class AppEndpointConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public AppEndpoint appEndpoint() {
        return new AppEndpoint();
    }

}
