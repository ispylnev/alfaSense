package alfasense.helper;


import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;


@Slf4j
/**
 * This is class provide handler for allure. Request and Response will be handle and  attach to allure reports
 */
public class AllureUtils extends AllureRestAssured {

    /**
     *
     * @param requestSpec handler for request filter
     * @param responseSpec handler for response filter
     * @param filterContext one of chain for rest assured. We can also expand this functional
     * @return
     */
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext filterContext) {
        AllureLifecycle lifecycle = Allure.getLifecycle();
        lifecycle.startStep(UUID.randomUUID().toString(), (new StepResult()).setStatus(Status.PASSED)
                .setName(String.format("%s: %s", requestSpec.getMethod(), requestSpec.getURI())));

        Response response;
        try {
            response = super.filter(requestSpec, responseSpec, filterContext);
        } finally {
            lifecycle.stopStep();
        }

        return response;
    }
}


