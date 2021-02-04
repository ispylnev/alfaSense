package alfasense.web.pet;

import alfasense.web.BaseApi;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PetApi extends BaseApi {

    private static String partOfUrl = "pet/";

    public String postPet() {
        String petUrl = init().concat(partOfUrl);
        log.info("make url -> " + petUrl);
        return petUrl;
    }

    public String deletePet(String id) {
        String petUrl = init()
                .concat(partOfUrl)
                .concat(String.valueOf(id));
        log.info("make url -> " + petUrl);
        return petUrl;
    }

    @AllArgsConstructor
    public enum PetHeader {
        API_KEY("key");
        String key;

        public static String getHeaderName() {
            return API_KEY.name();
        }

        public static String getHeaderValue() {
            return API_KEY.key;
        }
    }
}
