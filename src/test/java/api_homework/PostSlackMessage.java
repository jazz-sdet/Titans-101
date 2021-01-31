package api_homework;
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
import java.util.List;
import java.util.Map;
public class PostSlackMessage {
   @Test
    public static void postMss() throws IOException, URISyntaxException {
       HttpClient client= HttpClientBuilder.create().build();
       URIBuilder uriBuilder=new URIBuilder();
       //https://slack.com/api/conversations.history?channel=C01GEQL1GNQ
       uriBuilder.setScheme("https").setHost("slack.com").setPath("api/chat.postMessage");
       HttpPost httpPost=new HttpPost(uriBuilder.build());
       String appJason="application/json";
       httpPost.addHeader("accept",appJason);
       httpPost.addHeader("Content-Type", appJason);
       httpPost.addHeader("Authorization", "Bearer xoxb-1265938717187-1552841584019-5RRWy3TMd86ukXjHRpMpKM6Q");
       String myMss="Do you believe in Santa?";
       String postBody=PayloadUtils.getSlackMessagePayload(myMss);
       HttpEntity entity=new StringEntity(postBody);
       httpPost.setEntity(entity);
       HttpResponse response=client.execute(httpPost);
       Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
       Assert.assertTrue(response.getEntity().getContentType().getValue().contains(appJason));
       ObjectMapper objectMapper=new ObjectMapper();
       Map<String,Object> parsedValue=objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
       });
       Map<String, Object> messages= (Map<String, Object>) parsedValue.get("message");
       Assert.assertEquals(messages.get("text"), postBody);

//
//      boolean isOk= (boolean) parsedValue.get("ok");
//      if(!isOk){
//          Assert.fail("Message was not sent.");
//      }

       //Assert.assertEquals(messages.get("text"),postBody);

   }
}
