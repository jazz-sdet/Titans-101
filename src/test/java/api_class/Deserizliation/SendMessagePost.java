package api_class.Deserizliation;

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

public class SendMessagePost {
    @Test
    public void sendMssge() throws URISyntaxException, IOException {

        HttpClient client=HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        //https://slack.com/api/chat.postMessage
        uriBuilder.setScheme("https").setHost("slack.com").setPath("api/chat.postMessage");

        HttpPost post=new HttpPost(uriBuilder.build());

        post.addHeader("accept", "application/json");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer xoxb-1265938717187-1552841584019-5RRWy3TMd86ukXjHRpMpKM6Q");

        String givenMessage="I know what you did last summer";
        String messagePayload= PayloadUtils.getSlackMessagePayload(givenMessage);

        HttpEntity entity=new StringEntity(messagePayload);
        post.setEntity(entity);
        HttpResponse response=client.execute(post);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));


        ObjectMapper objectMapper=new ObjectMapper();
        
        Map<String,Object>parsedResponse=objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
        });

        boolean isOk= (boolean) parsedResponse.get("ok");

        if(!isOk){
            Assert.fail("Failed to post the message");
        }

        Map<String,Object>messageData= (Map<String, Object>) parsedResponse.get("message");

        String messageText=(String)messageData.get("text");

        Assert.assertEquals(messageText,givenMessage );

    }


}
