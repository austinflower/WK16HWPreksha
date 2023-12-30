package BestBuyApp.bestBuy3;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBestBuyApi3 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    @Test
    public void getallemployee(){
        given().log().all()
                .when()
                .get("http://localhost:3030/stores")
                .then().log().all()
                .statusCode(200);

    }

}
