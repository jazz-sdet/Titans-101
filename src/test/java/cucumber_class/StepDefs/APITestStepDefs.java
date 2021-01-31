package cucumber_class.StepDefs;

import api_class.Deserizliation.pojo.PetStorePojo;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APITestStepDefs {

    Response response;
    @When("user executes {string} request")
    public void user_executes_get_request(String request) {

       response=given().accept(ContentType.JSON).when()
                .get("https://petstore.swagger.io/v2/pet/1011");
    }


    @Then("status code is {int}")
    public void status_code_is(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("pet has following attributes")
    public void pet_has_following_attributes(io.cucumber.datatable.DataTable dataTable) {

       PetStorePojo parsedPet= response.as(PetStorePojo.class);
       List<Map<String, String>> maps=dataTable.asMaps();
       /*
       * | petName | pedID | pet status |
      | Pizza   | 1015  | available  |*/
       Map<String,String> petData=maps.get(0);
       String petName=petData.get("petName");
       String petStatus=petData.get("petStatus");
       int petID= Integer.parseInt(petData.get("petID"));

        Assert.assertEquals(parsedPet.getName(), petName);
        Assert.assertEquals(parsedPet.getStatus(),petStatus);
        Assert.assertEquals(parsedPet.getId(),petID);


    }
}
