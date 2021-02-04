package alfasense.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class BaseApi {

    @Value("${alfasense.api.v2}")
    private String defaultHost;

    private String host;


    protected String init() {
        String env = System.getProperty("host");
        if (env == null || env.equals("")) {
            host = defaultHost;
            log.info("use default Host -> " + defaultHost);
        } else {
            host = env;
            log.info("use host from variable -> " + defaultHost);
        }
        return host;
    }
}
