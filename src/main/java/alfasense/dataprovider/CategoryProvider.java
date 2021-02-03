package alfasense.dataprovider;

import alfasense.helper.RandomUtils;
import alfasense.models.Category;

public class CategoryProvider {

    public static Category getCategoryWithAllFilledFields() {
        return Category.builder()
                .id(RandomUtils.getRandomInt())
                .name(RandomUtils.getRandomEngString(10))
                .build();
    }
}
