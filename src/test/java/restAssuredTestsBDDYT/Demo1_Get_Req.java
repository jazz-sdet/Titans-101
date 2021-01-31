package restAssuredTestsBDDYT;

import Utils.RestUtilsYouT;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Demo1_Get_Req {

    @Test
    public void getDemo(){
        //http://api.got.show/api/general/characters
        Response response=given().accept(ContentType.JSON)
                .when()
                   .get("http://api.got.show/api/general/characters")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType(ContentType.JSON).extract().response();

        Map<String, Object> parsedResponse= JsonPath.from(response.asString()).getMap(".");

        List<Map<String, Object>> parsedList=JsonPath.from(response.asString()).getList("book");

    }

    public static HashMap map=new HashMap();

    @BeforeClass
    public void postData(){
        map.put("name", RestUtilsYouT.getName());
        map.put("id", RestUtilsYouT.getID());
        map.put("status", RestUtilsYouT.getStatus());

        RestAssured.baseURI="https://petstore.swagger.io/v2/pet";

    }
    @Test
    public void postDemo(){
       Response response= given()
                .contentType(ContentType.JSON)
                .body(map)
                .when().post()
                .then().statusCode(200).extract().response();

        Map<String, Object> parsed=JsonPath.from(response.asString()).getMap(".");
        System.out.println(parsed);

    }

}
