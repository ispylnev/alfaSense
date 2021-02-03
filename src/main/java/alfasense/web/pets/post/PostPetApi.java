package alfasense.web.pets.post;

import alfasense.web.BaseApi;
import org.springframework.stereotype.Service;

@Service
public class PostPetApi extends BaseApi {
    public String getUrl() {
        return init().concat("pet");
    }
}
