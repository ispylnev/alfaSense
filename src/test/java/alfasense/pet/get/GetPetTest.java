package alfasense.pet.get;

import alfasense.dto.Pet;
import alfasense.helper.AllureUtils;
import alfasense.junittags.OrderTest;
import alfasense.junittags.PetTest;
import alfasense.web.pets.post.PostPetApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.codehaus.groovy.runtime.InvokerHelper.asList;

@SpringBootTest
public class GetPetTest implements OrderTest {

    @Autowired
    PostPetApi postPetApi;

    @Test
    @DisplayName("sdohfsdh")
    void test() {
        Pet pet = Pet.builder()
                .name("test")
                .photoUrls(asList("photoUrl"))
                .build();

        Response response = given().contentType(ContentType.JSON)
                .filter(new AllureUtils())
                .body(pet)
                .when()
                .post(postPetApi.getUrl());
        response
                .then()
                .statusCode(200)
                .log().all();
        Pet pet1 = response.as(Pet.class);
    }

}
