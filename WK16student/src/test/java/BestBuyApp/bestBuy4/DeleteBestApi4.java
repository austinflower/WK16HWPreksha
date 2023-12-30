package BestBuyApp.bestBuy4;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteBestApi4 {
    RequestSpecification requestSpecification;
    Response response;
    ResponseSpecification responseSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void deleteproduct(){
        validatableResponse = given()
                .baseUri("http://localhost:3030/products/9999686")
                .contentType(ContentType.JSON)
                .when()
                .delete()
                .then()
                .assertThat().statusCode(200)
                .body("name",equalTo("Modern Housewares"));
        System.out.println("Response :" + validatableResponse.extract().asPrettyString());
    }
}
