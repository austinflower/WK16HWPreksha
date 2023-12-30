package BestBuyApp.bestBuy5;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PatchBestBuyApi5 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void patchservice(){
        String jsonData = "{\n" +
                "  \"name\": \"New Updates for use a Phone\"\n" +
                "}";
        RestAssured.baseURI = "http://localhost:3030/services/23";
        requestSpecification = given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonData);
        response = requestSpecification.patch();
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.body("name", equalTo("New Updates for use a Phone"));
        System.out.println("Response :" + validatableResponse.extract().asPrettyString());
    }





}
