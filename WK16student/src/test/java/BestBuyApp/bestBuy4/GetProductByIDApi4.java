package BestBuyApp.bestBuy4;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetProductByIDApi4 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    @Test
    public void getproductbyid(){
        RestAssured.baseURI="http://localhost:3030/products/150115";
        requestSpecification =RestAssured.given();
        response =requestSpecification.get();
        System.out.println(response.prettyPrint());
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
    }
}
