package alfasense.dataprovider;

import alfasense.utils.RandomUtils;
import alfasense.models.CategoryModel;

public class CategoryProvider {

    public static CategoryModel getCategoryFilledFields() {
        return CategoryModel.builder()
                .id(RandomUtils.getRandomInt())
                .name(RandomUtils.getRandomEngString(10))
                .build();
    }
}
