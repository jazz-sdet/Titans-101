package api_class;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class StarWarsAPI {

    @Test
    public void spaceShip() throws URISyntaxException, IOException {
        //http://swapi.dev/api/starships/?page=2

        HttpClient client= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost("swapi.dev");
        uriBuilder.setPath("api/starships");
        uriBuilder.setParameter("page", "2");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept", "application/json");

        HttpResponse response=client.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

    }

}
