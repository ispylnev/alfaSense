package alfasense.web.pet;

import alfasense.web.BaseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StoreApi extends BaseApi {

    private static String partOfUrl = "store/order/";

    public String orderPet() {
        String orderUrl = init().concat(partOfUrl);
        log.info("make url -> " + orderUrl);
        return orderUrl;
    }

}
