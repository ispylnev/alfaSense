package alfasense.pet.post;

import alfasense.CommonTest;
import alfasense.dto.Pet;
import alfasense.helper.AllureUtils;
import alfasense.junittags.PetTest;
import alfasense.web.pets.post.PostPetApi;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.codehaus.groovy.runtime.InvokerHelper.asList;

@SpringBootTest
public class PostPetTest implements PetTest {
    //9222968140497029422
    @Autowired
    PostPetApi postPetApi;

    @Test
    @DisplayName("pet")
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
        System.out.println(postPetApi.getUrl());
        Pet pet1 = response.as(Pet.class);
    }

}
