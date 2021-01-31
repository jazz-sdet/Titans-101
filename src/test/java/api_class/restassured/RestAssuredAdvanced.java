package api_class.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredAdvanced {

    RequestSpecification reqSpecif;
    ResponseSpecification resSpecif;

    @BeforeMethod
    public void setup(){
        RestAssured.baseURI="http://pokeapi.co";
        RestAssured.basePath="api/v2/ability";
        reqSpecif=new RequestSpecBuilder().setAccept(ContentType.JSON).build();
        resSpecif=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }

    @Test
    public void Test1(){
        given().spec(reqSpecif).when().get().then().spec(resSpecif);
    }
    @Test
    public void test2(){
        Response response=given().spec(reqSpecif).queryParam("limit", "1")
                .when().get().then().spec(resSpecif).extract().response();

        List<Map<String,String>> results= JsonPath.from(response.asString()).getList("results");
        Assert.assertEquals(results.size(),1);
    }


}
