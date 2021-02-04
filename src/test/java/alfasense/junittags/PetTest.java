package alfasense.junittags;

import alfasense.CommonTest;
import org.junit.jupiter.api.Tag;

/**
 * Implements this interfaces if you would like to tests will be launch with
 * gradle testPet
 */
@Tag(JunitTags.PET)
public interface PetTest extends CommonTest {
}
