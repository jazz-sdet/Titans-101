package api_class;
import Utils.PayloadUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
public class PostIntro {

    @Test
    public void postPetStore() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();
        //https://petstore.swagger.io/v2/pet
        URIBuilder uriBuilder=new URIBuilder();

        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");

        HttpPost post=new HttpPost(uriBuilder.build());
        post.addHeader("accept", "application/json");
        post.addHeader("Content-Type", "application/json");

        int ID=1015;
        String petName="Pizza";
        String petStatus="available";
        String postBody= PayloadUtils.getPetStore(ID,petName , petStatus);
        HttpEntity entity=new StringEntity(postBody);
        post.setEntity(entity);

        HttpResponse response=client.execute(post);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper=new ObjectMapper();
        Map<String, Object> deserializedResponse=objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        String actualPetName= (String) deserializedResponse.get("name");
        int actualPetId=(int)deserializedResponse.get("id");
        String actualPetStatus=(String)deserializedResponse.get("status");

        Assert.assertEquals(actualPetId, ID);
        Assert.assertEquals(actualPetName, petName);
        Assert.assertEquals(actualPetStatus, petStatus);
    }

}
