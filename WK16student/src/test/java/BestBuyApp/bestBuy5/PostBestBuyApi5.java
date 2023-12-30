package BestBuyApp.bestBuy5;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostBestBuyApi5 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    @Test
    public void creatservices(){
        String jsonData ="{\n" +
                "  \"name\": \"how to use a Phone\"\n" +
                "}";
        validatableResponse =given()
                .contentType(ContentType.JSON)
                .body(jsonData)
                .post("http://localhost:3030/services")
                .then()
                .statusCode(201)
                .body("name", equalTo("how to use a Phone"));
        System.out.println(validatableResponse.extract().asPrettyString());


    }



}
