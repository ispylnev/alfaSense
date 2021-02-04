package alfasense.dataprovider;

import alfasense.dto.Pet;
import alfasense.models.PetStatus;
import alfasense.utils.RandomUtils;
import lombok.experimental.UtilityClass;

import java.util.Collections;

@UtilityClass
public class PetProvider {

    public static Pet getPetFilledFields() {
        return Pet.builder()
                .id(String.valueOf(RandomUtils.getRandomInt()))
                .category(CategoryProvider.getCategoryFilledFields())
                .name(RandomUtils.getRandomEngString(10))
                .photoUrls(Collections.singletonList(RandomUtils.getRandomEngString(11)))
                .tags(Collections.singletonList(TagProvider.getTagWithFilledFields()))
                .status(PetStatus.AVAILABLE)
                .build();

    }

    public static Pet onlyRequiredFields() {
        return Pet.builder()
                .name(RandomUtils.getRandomEngString(10))
                .photoUrls(Collections.singletonList(RandomUtils.getRandomEngString(11)))
                .build();
    }

}
