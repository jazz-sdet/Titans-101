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
import java.util.List;
import java.util.Map;

public class pokemonTask {
    @Test
    public void pokemon() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();

        uriBuilder.setScheme("https").setHost("pokeapi.co").setPath("api/v2/ability");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept", "application/json");

        HttpResponse response=client.execute(httpGet);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper=new ObjectMapper();


        Map<String, Object> deserializedResponse=objectMapper.readValue(response.getEntity().getContent(), //response body
                new TypeReference<Map<String,Object>>() { //helps to map json res to specific java data type
        });

        //needs to be casted coz one side is List<Map> the other side is Object
        List<Map<String, String>> result = (List<Map<String, String>>) deserializedResponse.get("results");

        for(int i=0; i<result.size();i++){
           Map<String, String>map= result.get(i);
            System.out.println(map.get("name"));
        }

    }
}
