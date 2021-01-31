package api_class.Serialization;
import api_class.Deserizliation.pojo.PetStorePojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializationIntro {

    @Test
    public void test1() throws IOException {
        PetStorePojo pet=new PetStorePojo(909, "Muffin", "asleep");

//        pet.setId(999);
//        pet.setName("Snowflake");
//        pet.setStatus("gone");
        ObjectMapper objectMapper=new ObjectMapper();
        File petJson=new File("src/test/java/api_class/Serialization/pet.json");
        objectMapper.writeValue(petJson, pet);
    }
    @Test
    public void test2() throws IOException, URISyntaxException {
        PetStorePojo pet=new PetStorePojo(321, "Thomas", "playing");
        ObjectMapper objectMapper=new ObjectMapper();
        StringWriter stringWriter=new StringWriter();//storing in a memory (instead of storing in storage.)
        objectMapper.writeValue(stringWriter, pet);
        System.out.println(stringWriter);

        HttpClient client=HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");
        HttpPost post=new HttpPost(uriBuilder.build());

        post.addHeader("accept", "application/json");
        post.addHeader("Content-Type", "application/json");

        HttpEntity entity=new StringEntity(stringWriter.toString());
        post.setEntity(entity);
        HttpResponse response=client.execute(post);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void test3() throws URISyntaxException, IOException {
        HttpClient client=HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");
        HttpPost post=new HttpPost(uriBuilder.build());

        post.addHeader("accept", "application/json");
        post.addHeader("Content-Type", "application/json");

        byte[] bytes=Files.readAllBytes(Paths.get("src/test/java/api_class/Serialization/pet.json"));
        String jsonContent=new String (bytes);
        HttpEntity entity=new StringEntity(jsonContent);
        post.setEntity(entity);

        HttpResponse response=client.execute(post);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

    }
}
