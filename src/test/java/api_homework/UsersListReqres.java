package api_homework;
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

public class UsersListReqres {
    @Test
    public void userQuantity() throws URISyntaxException, IOException {
        HttpClient client=HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users");

        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.addHeader("accept", "application/json");

        HttpResponse response=client.execute(httpGet);

        int actual=response.getStatusLine().getStatusCode();

        Assert.assertEquals(actual, HttpStatus.SC_OK);

        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper=new ObjectMapper();


        List<Map<String, Object>> dataFromResponse=objectMapper.readValue(response.getEntity().getContent(), new TypeReference<List<Map<String, Object>>>() {
       });



        //String arr[]=new String[dataFromResponse.size()];

        for(int i=0; i<dataFromResponse.size(); i++){


        }


//
//
//
//       Map<String, Object> data=(Map<String, Object> )dataFromResponse.get("data");
//        System.out.println(data);
    }
}
