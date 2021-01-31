package api_class.restassured;
import api_class.Deserizliation.pojo.PetStorePojo;
import com.sun.xml.bind.api.TypeReference;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class GetRequest {

    @Test
    public void getTest(){
    //https://petstore.swagger.io/v2/pet/1011

        given().accept("application/json")
                .when().get("https://petstore.swagger.io/v2/pet/1011")
                .then().statusCode(200).contentType("application/json");

    }

    @Test
    public void getTest1(){
        given().accept("application/json")
                .when().get("http://swapi.dev/api/people")
                .then().statusCode(200).contentType("application/json").log().all();
    }

    @Test
    public void getTest3(){

        given().accept(ContentType.JSON)
                .when().get("https://petstore.swagger.io/v2/pet/1011")
                .then().statusCode(200).contentType(ContentType.JSON)
                .and().body("id", equalTo(1011))
                .and().body("category.name", is("German Shepard"));
    }

    @Test
    public void getTest4(){
        given().accept(ContentType.JSON)
                .when().get("https://pokeapi.co/api/v2/ability")
                .then().statusCode(200).contentType(ContentType.JSON)
                .and().body("count", equalTo(327))
                .and().body("results[2].name", is("speed-boost"))
                .and().body("results.name", Matchers.anything("speed-boost"));
    }

    @Test
    public void iTunesTest1(){
        given().accept(ContentType.JSON).queryParam("term", "greenday")
                .when().get("https://itunes.apple.com/search")
                .then().statusCode(200).contentType(ContentType.JSON)
                .and().body("resultCount", Matchers.equalTo(50));
    }
    @Test
    public void iTunesGetTest() {
        Response response = given().accept(ContentType.JSON).queryParam("term", "greenday")
                .when().get("https://itunes.apple.com/search")
                .then().statusCode(200).contentType(ContentType.JSON).extract().response();

        //as() method is like an object mapper. It defines typereference
        Map<String, Object> parsedResponse = response.as(new TypeRef<Map<String, Object>>() {
       });
       List<Map<String, Object>> resultsDataList = (List<Map<String, Object>>) parsedResponse.get("results");
        assertEquals(50, resultsDataList);

    }
    @Test
    public void swapiTest(){
        RestAssured.baseURI="http://swapi.dev/api/people";
        Response response=given().accept(ContentType.JSON)
                .when().get()
                .then().statusCode(200).contentType(ContentType.JSON).extract().response();

        Map<String, Object> deserResp=response.as(new TypeRef<Map<String, Object>>() {
        });

        List<Map<String, Object>> resultList= (List<Map<String, Object>>) deserResp.get("results");
        assertEquals(resultList.get(0).get("name"), "Luke Skywalker");
    }

    @Test
    public void petTest(){
        RestAssured.baseURI="https://petstore.swagger.io";
        RestAssured.basePath="v2/pet/1015";
        Response response=given().accept(ContentType.JSON)
                .when().get()
                .then().statusCode(200).contentType(ContentType.JSON).extract().response();

        PetStorePojo deserRes=response.as(PetStorePojo.class);
        assertEquals(deserRes.getName(), "Pizza");
        assertEquals(deserRes.getStatus(),"available");
    }
    @Test
    public void petTest2(){
       Response response= given().accept(ContentType.JSON)
                .when().get("http://swapi.dev/api/people")
                .then().statusCode(200).contentType(ContentType.JSON).extract().response();

        Map<String, Object> parsedResponse=JsonPath.from(response.asString()).getMap(".");
        System.out.println(parsedResponse);
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        List<Map<String,Object>> results=JsonPath.from(response.asString()).getList("results");
        System.out.println(results);


        int count=JsonPath.from(response.asString()).getInt("count");
        System.out.println("Count is: "+count);


    }
    }
