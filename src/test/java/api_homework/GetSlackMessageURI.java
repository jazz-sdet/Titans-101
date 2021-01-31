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

public class GetSlackMessageURI {
    @Test
    public static void uri_Def() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        //https://slack.com/api/conversations.history?channel=C01GEQL1GNQ
        uriBuilder.setScheme("https").setHost("slack.com").setPath("api/conversations.history").setParameter("channel", "C01GEQL1GNQ");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        String appJason="application/json";
        httpGet.addHeader("accept",appJason);
        httpGet.addHeader("Content-Type", appJason);
        httpGet.addHeader("Authorization", "Bearer xoxb-1265938717187-1552841584019-5RRWy3TMd86ukXjHRpMpKM6Q");

        HttpResponse response=client.execute(httpGet);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

       Assert.assertTrue(response.getEntity().getContentType().getValue().contains(appJason));

        ObjectMapper objectMapper=new ObjectMapper();


        Map<String,Object> parsedResponse = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
        });

        List<Map<String,Object>> messageList= (List<Map<String, Object>>) parsedResponse.get("messages");
        String myMessage="Good evening people, Zhazgul";

        for(int i=0; i<messageList.size(); i++){
            Map<String, Object> messages=(Map<String, Object>)messageList.get(i);
           String mss= (String) messages.get("text");
            System.out.println(mss);

            Assert.assertTrue(!mss.equals(myMessage));


        }





    }
}
