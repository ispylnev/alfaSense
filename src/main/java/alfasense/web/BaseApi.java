package alfasense.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseApi {

    @Value("${alfasense.api.baseUrl}")
    private String defaultHost;

    private String host;


    protected String init() {
        String env = System.getProperty("host");
        if (env == null|| env.equals("")) {
            host = defaultHost;
        } else {
            host = env;
        }
        return host;
    }
}
