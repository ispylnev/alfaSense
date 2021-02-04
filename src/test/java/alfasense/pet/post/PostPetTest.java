package alfasense.pet.post;

import alfasense.dataprovider.PetProvider;
import alfasense.dto.Pet;
import alfasense.helper.AllureHelper;
import alfasense.junittags.PetTest;
import alfasense.utils.AssertUtils;
import alfasense.web.pet.PetApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import java.util.Collections;

import static io.restassured.RestAssured.given;

@SpringBootTest
@DisplayName("/pet")
public class PostPetTest implements PetTest {

    @Autowired
    PetApi petApi;

    @DisplayName("200 OK POST /pet")
    @Description("Test successful create pet with full filled fields and server return valid model")
    @Test
    void postPetFilledFieldsTest() {
        Pet pet = PetProvider.getPetFilledFields();

        Response response = given().contentType(ContentType.JSON)
                .filter(new AllureHelper())
                .body(pet)
                .when()
                .post(petApi.postPet());
        response
                .then()
                .statusCode(200)
                .log().all();

        Pet actualResponsePet = response.as(Pet.class);
        AssertUtils.assetBeansEqual(pet, actualResponsePet, Collections.singletonList("id"));
    }


    @DisplayName("200 OK POST /pet")
    @Description("Test successful create pet with full filled fields and server return valid model")
    @Test
    void postPetReqFieldsTest() {
        Pet pet = PetProvider.onlyRequiredFields();

        Response response = given().contentType(ContentType.JSON)
                .filter(new AllureHelper())
                .body(pet)
                .when()
                .post(petApi.postPet());
        response
                .then()
                .statusCode(200)
                .log().all();

        Pet actualResponsePet = response.as(Pet.class);
        AssertUtils.assetBeansEqual(pet, actualResponsePet, Collections.singletonList("id"));
    }

}
