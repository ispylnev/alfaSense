package alfasense.dataprovider;


import alfasense.models.TagModel;
import alfasense.utils.RandomUtils;

public class TagProvider {

    public static TagModel getTagWithFilledFields() {
        return TagModel.builder()
                .id(RandomUtils.getRandomInt())
                .name(RandomUtils.getRandomEngString(10))
                .build();
    }
}
