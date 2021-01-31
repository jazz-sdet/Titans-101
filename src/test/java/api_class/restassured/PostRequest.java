package api_class.restassured;
import Utils.Constants;
import Utils.PayloadUtils;
import api_class.Deserizliation.pojo.PetStorePojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;

import static Utils.Constants.ID;
import static io.restassured.RestAssured.given;

public class PostRequest {
    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
    }
    @Test
    public void postReq1(){

        String petName="Silvester";
        String petStatus="asleep";
        int petID=1014;

        String requestPayload= PayloadUtils.getPetStore(petID, petName, petStatus);

        given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(requestPayload)
                .when().post()
                .then().statusCode(200)
                .and().body("id", Matchers.equalTo(petID))
                .and().body("name", Matchers.is(petName))
                .and().body("status", Matchers.is(petStatus));

    }
    @Test
    public void postReq2(){
        File petPayload=new File("src/test/java/api_class/Serialization/pet.json");
        given().accept(ContentType.JSON).contentType(ContentType.JSON).body(petPayload)
                .when().post()
                .then().statusCode(200)
                .and().body("id", Matchers.equalTo(909))
                .and().body("name", Matchers.equalTo("Muffin"))
                .and().body("status", Matchers.equalTo("asleep"));
    }

    @Test
    public void postReq3(){
        int petID=1017;
        String petName="Cookie";
        String petStatus="gone";
        PetStorePojo pet=new PetStorePojo(petID, petName,petStatus);

        given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(pet)
                .when().post()
                .then().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().body(ID, Matchers.equalTo(petID))
                .and().body(Constants.NAME, Matchers.equalTo(petName))
                .and().body(Constants.STATUS, Matchers.equalTo(petStatus));
    }
}
