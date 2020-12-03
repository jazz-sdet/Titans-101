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

public class GetTask {

    @Test
    public  void testGet1() throws URISyntaxException, IOException {

        HttpClient client= HttpClientBuilder.create().build();

        //https://reqres.in/api/users/2
        URIBuilder uriBuilder=new URIBuilder();

        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users/2");

        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.addHeader("accept", "application/json");

        HttpResponse httpResponse=client.execute(httpGet);

        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);



    }

    @Test
    public  void testGet2() throws IOException, URISyntaxException {


        HttpClient client= HttpClientBuilder.create().build();

        //https://reqres.in/api/users/2
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users/23");

        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.addHeader("accept", "application/json");

        HttpResponse httpResponse=client.execute(httpGet);

        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), 404);

    }
}
