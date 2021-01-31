package api_class.get;

import api_class.Deserizliation.pojo.starWarPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class StarWarGetPojo {

    @Test
    public void starWar() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        http://swapi.dev/api/starships/?page=2
        uriBuilder.setScheme("https").setHost("swapi.dev").setPath("api/starships").setParameter("page","1");

        HttpGet get=new HttpGet(uriBuilder.build());

        get.addHeader("accept", "application/json");

        HttpResponse response=client.execute(get);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        ObjectMapper objectMapper=new ObjectMapper();
        starWarPojo parsedData=objectMapper.readValue(response.getEntity().getContent(), starWarPojo.class);
        //int counter loop thru, gets from next, use split

    }
}
