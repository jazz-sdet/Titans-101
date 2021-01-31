package api_class;

import Utils.PayloadUtils;
import io.cucumber.java.bs.I;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import java.net.URISyntaxException;

public class PutIntro {

    @Test
    public void petStoreUpdate() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        //https://petstore.swagger.io/v2/pet
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");

        HttpPut put=new HttpPut(uriBuilder.build());

        put.addHeader("accept", "application/json");
        put.addHeader("Content-Type", "application/json");


        String namePayload="Dolce";
        int ID=1010;
        String statusPayload="sleeping";
        String putRequestPayload=PayloadUtils.getPetStore(ID, namePayload,statusPayload);
        HttpEntity entity=new StringEntity(putRequestPayload);
        put.setEntity(entity);
        HttpResponse response=client.execute(put);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));




    }
}
