package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import utils.PropertiesRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class Api_Films_Defs {

    HttpClient client= HttpClientBuilder.create().build();
    URIBuilder uriBuilder=new URIBuilder();
    HttpGet httpGet=new HttpGet();
    HttpResponse response;


    @When("user creates get request by using path")
    public void user_creates_get_request_by_using() throws URISyntaxException, IOException {
        uriBuilder.setScheme(PropertiesRunner.readPropertyByKey("protocolS"));
        uriBuilder.setHost(PropertiesRunner.readPropertyByKey("host"));
        uriBuilder.setPath(PropertiesRunner.readPropertyByKey("pathFilm"));

        httpGet=new HttpGet(uriBuilder.build());

        httpGet.addHeader("accept", "application/json");

        response=client.execute(httpGet);
    }




    @Then("user gets the status code {int}")
    public void user_gets_the_status_code(int statusCode) {
        System.out.println(response.getStatusLine().getStatusCode());
        Assert.assertEquals(response.getStatusLine().getStatusCode(), statusCode);

    }


    @When("user will creates get request by using invalid path")
    public void user_will_creates_get_request_by_using_invalid_path() throws URISyntaxException, IOException {

        uriBuilder.setScheme(PropertiesRunner.readPropertyByKey("protocolS"));
        uriBuilder.setHost(PropertiesRunner.readPropertyByKey("host"));
        uriBuilder.setPath("film");

        httpGet=new HttpGet(uriBuilder.build());

        httpGet.addHeader("accept", "application/json");

        response=client.execute(httpGet);

    }

    @Then("user will get status code {int}")
    public void user_will_get_status_code(int unexpStatCode) {
        System.out.println(response.getStatusLine().getStatusCode());
        Assert.assertEquals(response.getStatusLine().getStatusCode(),unexpStatCode);

    }

    @When("user creates get request by using path people")
    public void user_creates_get_request_by_using_path_people() throws IOException, URISyntaxException {
        uriBuilder.setScheme(PropertiesRunner.readPropertyByKey("protocolS"));
        uriBuilder.setHost(PropertiesRunner.readPropertyByKey("host"));
        uriBuilder.setPath(PropertiesRunner.readPropertyByKey("pathPeople"));

        httpGet=new HttpGet(uriBuilder.build());

        httpGet.addHeader("accept", "application/json");

        response=client.execute(httpGet);

    }


    @When("user creates get request by using path people1")
    public void user_creates_get_request_by_using_path_people1() throws URISyntaxException, IOException {

        uriBuilder.setScheme(PropertiesRunner.readPropertyByKey("protocolS"));
        uriBuilder.setHost(PropertiesRunner.readPropertyByKey("host"));
        uriBuilder.setPath(PropertiesRunner.readPropertyByKey("pathLukeSkywalker "));

        httpGet=new HttpGet(uriBuilder.build());

        httpGet.addHeader("accept", "application/json");

        response=client.execute(httpGet);

    }

    @When("user creates get request by using path vehicle")
    public void user_creates_get_request_by_using_path_vehicle() throws URISyntaxException, IOException {

        uriBuilder.setScheme(PropertiesRunner.readPropertyByKey("protocolS"));
        uriBuilder.setHost(PropertiesRunner.readPropertyByKey("host"));
        uriBuilder.setPath(PropertiesRunner.readPropertyByKey("pathVehicles"));

        httpGet=new HttpGet(uriBuilder.build());

        httpGet.addHeader("accept", "application/json");

        response=client.execute(httpGet);

    }



}
