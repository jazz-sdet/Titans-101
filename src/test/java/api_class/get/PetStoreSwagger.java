package api_class.get;

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

public class PetStoreSwagger {
    @Test
    public void swag() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        //https://petstore.swagger.io/v2/pet/findByStatus?status=sold

        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet/findByStatus")
                .setParameter("status","sold");

        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.addHeader("accept", "application/json");

        HttpResponse response=client.execute(httpGet);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper=new ObjectMapper();
        List<Map<String,Object>> deserializedList=objectMapper.readValue(response.getEntity().getContent(), new TypeReference<List<Map<String,Object>>>(){
        });

        for(int i=0; i<deserializedList.size(); i++) {
            Map<String, Object> map = deserializedList.get(i);
            System.out.println("id: " + map.get("id") + " name: " + map.get("name"));

            Map<String, Object> category = (Map<String, Object>) map.get("category");
            if (category != null)//there r some category missing
                System.out.println("category id: " + category.get("id") + ", category name: " + category.get("name"));


            List<Map<String, Object>> tagsDataList = (List<Map<String, Object>>) map.get("tags");
            if (tagsDataList != null) {
                for (int b = 0; b < tagsDataList.size(); i++) {

                    Map<String, Object> tags = tagsDataList.get(b);
                    System.out.println("id: " + tags.get("id") + ", name: " + tags.get("name"));
                }
            }
        }

    }
}
