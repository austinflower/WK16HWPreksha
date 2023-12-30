package BestBuyApp.bestBuy3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteBestApi3 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    @Test
    public void deleteStore(){
        validatableResponse = given()
                .baseUri("http://localhost:3030/stores/8929")
                .contentType(ContentType.JSON)
                .when()
                .delete()
                .then()
                .assertThat().statusCode(200)
                .body("name", equalTo("PrekshaP89298929"));

        System.out.println("Response :" + validatableResponse.extract().asPrettyString());
    }

    }




