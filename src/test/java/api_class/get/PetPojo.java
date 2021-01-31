package api_class.get;
import api_class.Deserizliation.pojo.PetStorePojo;
import api_class.Deserizliation.pojo.petPojoOption2;
import com.fasterxml.jackson.databind.DeserializationFeature;
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
public class PetPojo {
    @Test
    public void pet() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        //https://petstore.swagger.io/v2/pet/10010000000
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet/10010000000");

        HttpGet get=new HttpGet(uriBuilder.build());

        get.addHeader("accept", "application/json");

        HttpResponse response=client.execute(get);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        ObjectMapper objectMapper=new ObjectMapper();
       PetStorePojo parsedData =objectMapper.readValue(response.getEntity().getContent(), PetStorePojo.class);
        Assert.assertEquals(parsedData.getId(), 10010000000l);
        Assert.assertEquals(parsedData.getName(),"Hutch");
        Assert.assertEquals(parsedData.getStatus(),"good pet");

        Map<String,Object> categoryData=parsedData.getCategory();
        int categoryId= (int) categoryData.get("id");
        String categoryName= (String) categoryData.get("name");
       Assert.assertEquals(categoryId, 700);
       Assert.assertEquals(categoryName, "German Shepard");

    }


    @Test
    public void pet2() throws URISyntaxException, IOException {

        HttpClient client= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        //https://petstore.swagger.io/v2/pet/10010000000
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet/10010000000");

        HttpGet get=new HttpGet(uriBuilder.build());

        get.addHeader("accept", "application/json");

        HttpResponse response=client.execute(get);

        //Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        petPojoOption2 parsedPet=objectMapper.readValue(response.getEntity().getContent(), petPojoOption2.class);

        System.out.println(parsedPet.getCategory());
    }
}
