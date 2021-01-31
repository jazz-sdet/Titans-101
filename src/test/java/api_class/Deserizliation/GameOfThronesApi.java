package api_class.Deserizliation;

import com.fasterxml.jackson.core.type.TypeReference;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameOfThronesApi {

    @Test
    public void gameOfThrones() throws URISyntaxException, IOException {


        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        //api.got.show/api/show/characters
        uriBuilder.setScheme("https").setHost("api.got.show").setPath("api/show/characters");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept", "application/json");

        HttpResponse response=client.execute(httpGet);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper=new ObjectMapper();

        List<Map<String, Object>>deserData=objectMapper.readValue(response.getEntity().getContent(), new TypeReference<List<Map<String, Object>>>() {
        });


        List<String>names=new ArrayList<>();
        for(int i=0; i<deserData.size(); i++){
            Map<String, Object> mapData=deserData.get(i);
            names.add(mapData.get("names").toString());//toString to convert it to String data type
        }
        Assert.assertTrue(names.size()>100);
    }
}



