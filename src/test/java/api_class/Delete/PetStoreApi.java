package api_class.Delete;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PetStoreApi {

    HttpClient httpClient= HttpClientBuilder.create().build();
    URIBuilder uriBuilder=new URIBuilder();

    @BeforeMethod
    public void setUp() throws URISyntaxException, IOException {

        uriBuilder.setHost("petstore.swagger.io/v2/pet").setScheme("https");
        HttpPost post=new HttpPost(uriBuilder.build());

        post.addHeader("accept", "application/json");
        post.addHeader("Content-Type", "application/json");
        byte[] bytes= Files.readAllBytes(Paths.get("src/test/java/api_class/Serialization/pet.json"));
        String jsonContent=new String (bytes);
        HttpEntity entity=new StringEntity(jsonContent);
        post.setEntity(entity);

        HttpResponse response=httpClient.execute(post);


    }

    @Test
    public void deletePetTest() throws URISyntaxException, IOException {
        uriBuilder.setPath("909");



        HttpDelete delete=new HttpDelete(uriBuilder.build());
        delete.addHeader("accept", "application/json");

        HttpResponse response=httpClient.execute(delete);

        int statusCode=response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
    }
}
