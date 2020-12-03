package HomeWork.api_hwork;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class GetApi {
    //http://swapi.dev/api/starships/?page=2

    @Test
    public void getTest1() throws URISyntaxException, IOException {

        HttpClient httpClient= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost("swapi.dev");
        uriBuilder.setPath("api/starships");
        uriBuilder.setParameter("page", "2");

        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.addHeader("accept", "application/json");

        HttpResponse response=httpClient.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);



    }


}
