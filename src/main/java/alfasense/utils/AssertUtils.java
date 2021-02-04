package alfasense.utils;

import com.shazam.shazamcrest.matcher.CustomisableMatcher;
import lombok.experimental.UtilityClass;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;

@UtilityClass
public class AssertUtils {

    /**
     *
     * @param expected model
     * @param actual model
     * @param ignoreFields if you want ignore fields add to list
     *
     */
    public static <T> void assetBeansEqual(T expected,
                                           T actual,
                                           @NotNull List<String> ignoreFields) {
        CustomisableMatcher<T> wrapperForExpectedResult = sameBeanAs(expected);
        addIgnoreFieldsToSingleWrapper(wrapperForExpectedResult, ignoreFields);
        assertThat("expected model does not equals with actual",
                actual, wrapperForExpectedResult);
    }

    public static <T> void assetBeansEqual(T expected, T actual) {
        CustomisableMatcher<T> wrapperForExpectedResult = sameBeanAs(expected);
        addIgnoreFieldsToSingleWrapper(wrapperForExpectedResult, Collections.emptyList());
        assertThat("expected model does not equals with actual",
                actual, wrapperForExpectedResult);
    }

    private static <T> void addIgnoreFieldsToSingleWrapper(
            CustomisableMatcher<T> objectForAddingIgnoringFields,
            List<String> ignoreFields) {

        for (String ignore : ignoreFields) {
            objectForAddingIgnoringFields = objectForAddingIgnoringFields.ignoring(ignore);
        }
    }
}
