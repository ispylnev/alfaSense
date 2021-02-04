package alfasense.pet.delete;

import alfasense.dto.Pet;
import alfasense.helper.AllureHelper;
import alfasense.junittags.OrderTest;
import alfasense.models.DeleteModel;
import alfasense.utils.RandomUtils;
import alfasense.web.pet.PetApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import static io.restassured.RestAssured.given;
import static org.codehaus.groovy.runtime.InvokerHelper.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("/pet")
public class DeletePetTest implements OrderTest {

    @Autowired
    private PetApi petApi;

    private static String preconditionPetId = "123";

    @BeforeEach
    void beforeEachTest() {
        Pet pet = Pet.builder()
                .name("test")
                .id(preconditionPetId)
                .photoUrls(asList("photoUrl"))
                .build();
        given().contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(petApi.postPet())
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("200 OK DELETE /pet")
    @Description("200 Ok Test successful delete pet")
    void deletePetTest() {
        Response response = given().contentType(ContentType.JSON)
                .filter(new AllureHelper())
                .header(PetApi.PetHeader.getHeaderName(), PetApi.PetHeader.getHeaderValue())
                .when()
                .delete(petApi.deletePet(preconditionPetId));
        response
                .then()
                .statusCode(200)
                .log().all();
        DeleteModel petDelete = response.as(DeleteModel.class);
        assertEquals(preconditionPetId, petDelete.getMessage(), "pet id is not correct");
    }

    @Test
    @DisplayName("404 DELETE /pet")
    void notFoundDeletePetTest() {
        Response response = given().contentType(ContentType.JSON)
                .filter(new AllureHelper())
                .header(PetApi.PetHeader.getHeaderName(), PetApi.PetHeader.getHeaderValue())
                .when()
                .delete(petApi.deletePet(String.valueOf(RandomUtils.getRandomInt())));
        response
                .then()
                .statusCode(404)
                .log().all();
    }
}
