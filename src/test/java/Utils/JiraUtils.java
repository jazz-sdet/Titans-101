package Utils;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class JiraUtils {

    public static String getSessionId(){
       return given().accept(ContentType.JSON).contentType(ContentType.JSON).body(PayloadUtils.JiraAuthPayload())
                .when().post("http://localhost:8080/rest/auth/1/session")
                .then().statusCode(200).extract().response().jsonPath().getString("session.value");

//        Map<String, Object> parsedResponse=response.as(new TypeRef<Map<String, Object>>() {
//        });
//        Map<String, String> sessionData= (Map<String, String>) parsedResponse.get("session");
//        String value=sessionData.get("value");

//        String value1=response.jsonPath().getString("session.value");
//        System.out.println(value1);
//        return value;


    }
}
