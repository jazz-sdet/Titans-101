package api_class.restassured;

import Utils.Constants;
import api_class.Deserizliation.pojo.PetStorePojo;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PutRequest {
    @Test
    public void updatePetTest(){
        int petID=1016;
        String petName="Cookie";
        String petStatus="gone";
        PetStorePojo pet=new PetStorePojo(petID, petName,petStatus);
        given().accept(ContentType.JSON).contentType(ContentType.JSON).body(pet)
                .when().put("https://petstore.swagger.io/v2/pet")
                .then().statusCode(200)
                .and().body(Constants.ID, is(petID))
                .and().body(Constants.NAME, is(petName))
                .and().body(Constants.STATUS, is(petStatus));
    }
}
