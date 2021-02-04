package alfasense.order;

import alfasense.dataprovider.OrderProvider;
import alfasense.dto.Order;
import alfasense.helper.AllureHelper;
import alfasense.junittags.OrderTest;
import alfasense.utils.AssertUtils;
import alfasense.web.pet.StoreApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import static io.restassured.RestAssured.given;

@SpringBootTest
@DisplayName("/order")
public class PostOrderTest implements OrderTest {

    @Autowired
    private StoreApi orderApi;

    @Test
    @DisplayName("200 OK POST /order")
    @Description("successful  order the pet")
    void orderPetTest() {
        Order expectedOrder = OrderProvider.getOrderFilledFields();
        Response response = given().contentType(ContentType.JSON)
                .filter(new AllureHelper())
                .body(expectedOrder)
                .when()
                .post(orderApi.orderPet());
        response
                .then()
                .statusCode(200)
                .log().all();
        AssertUtils.assetBeansEqual(expectedOrder, response.as(Order.class));
    }

    //todo  issue-2.md

    @Test
    @DisplayName("404 NotFound POST /order")
    @Description("pet id not found")
    void notFoundOrderPetTest() {
        Response response = given().contentType(ContentType.JSON)
                .filter(new AllureHelper())
                .body(Order.builder()
                        .id("0")
                        .build())
                .when()
                .post(orderApi.orderPet());
        response
                .then()
                .statusCode(404)
                .log().all();
    }
}
