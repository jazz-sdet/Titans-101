package api_class.get;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.URISyntaxException;

public class GetIntro {
    /**
     * Launch the client(postman)
     * Construct URL
     * Define the HTTP methods (Get, Post,Put, Delelete)
     * Add parameters (if needed)
     * path params
     * query param
     * header
     * click the Send button to execute/call
     */
    @Test
    public void getTest() throws URISyntaxException, IOException {
        //Launch the client(postman)
        HttpClient client= HttpClientBuilder.create().build();

        //Construct URL https://petstore.swagger.io//v2/store/inventory
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/store/inventory");

        //Define the HTTP methods
        HttpGet httpGet=new HttpGet(uriBuilder.build());

        //Add parameters (if needed)
        httpGet.addHeader("accept", "application/json");

        //click the Send button to execute/call
        HttpResponse response= client.execute(httpGet);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);


    }


}
