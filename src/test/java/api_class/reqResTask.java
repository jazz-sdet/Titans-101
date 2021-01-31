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

public class reqResTask {

    @Test
    public void task() throws IOException, URISyntaxException {
        // //https://reqres.in/api/users/1
        HttpClient client= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();

        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users/1");

        HttpGet get=new HttpGet(uriBuilder.build());

        get.addHeader("accept", "application/json");

        HttpResponse response=client.execute(get);

        int actualOutput=response.getStatusLine().getStatusCode();
        System.out.println(actualOutput);

        //asserting the status code
        Assert.assertEquals(actualOutput, HttpStatus.SC_OK);

        //asserting the format
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        //start of the deserialization with ObjectMapper
        ObjectMapper objectMapper=new ObjectMapper();

        //conversion of json to java
        Map<String, Object> deserializedResponse=objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        System.out.println(deserializedResponse);

        //already converted to java
        //Object support=deserializedResponse.get("support");
        //System.out.println(support);
        Map<String, String> supportData=(Map<String, String>)deserializedResponse.get("support");
        System.out.println(deserializedResponse.get("support"));
        System.out.println();
        System.out.println(supportData.get("url"));


    }



}
