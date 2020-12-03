package api_class;

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
import java.util.Map;

public class ReqRes_Api {


    @Test
    public void getUserByIdTest() throws URISyntaxException, IOException {
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
        HttpClient httpClient= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();

        //https://reqres.in/api/users/1
        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users/1");

        HttpGet httpGet=new HttpGet(uriBuilder.build());

        httpGet.addHeader("accept", "application/json");

       HttpResponse response= httpClient.execute(httpGet);

       int actualStatusCode=response.getStatusLine().getStatusCode();

        Assert.assertEquals(actualStatusCode, HttpStatus.SC_OK);

        //verify response header ContentType
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        //Deserialization
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String, Object> dataFromResponse=objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        Map<String,Object> data= (Map<String, Object>) dataFromResponse.get("data");

        System.out.println(data.get("first_name"));

        System.out.println(dataFromResponse.get("data"));



    }
}
