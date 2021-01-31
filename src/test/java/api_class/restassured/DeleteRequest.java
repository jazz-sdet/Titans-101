package api_class.restassured;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest {
    @Test
    public void deleteTest(){
        given().accept(ContentType.JSON)
                .when().delete("https://petstore.swagger.io/v2/pet/1012")
                .then().statusCode(200).contentType(ContentType.JSON)
                .and().body("code", Matchers.equalTo(200))
                .body("type", Matchers.is("unknown"));
    }

    @Test
    public void deleteTest2(){
        given().accept(ContentType.JSON)
                .when().delete("https://petstore.swagger.io/v2/pet/1012")
                .then().statusCode(404)
                .and().body("code", Matchers.is(404));


    }

}
