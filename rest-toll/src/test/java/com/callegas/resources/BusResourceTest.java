package com.callegas.resources;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;


public class BusResourceTest {

    HttpUriRequest request = new HttpGet( "http://localhost:8080/toll/bus/20" );
    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

    public BusResourceTest() throws IOException {
    }

    @Test
    public void whenAccessTollWithBus_then200IsReceived() {
        Assert.assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void whenAccessTollWithBusWithoutPayment_then404IsReceived() throws IOException {
        HttpUriRequest request = new HttpGet( "http://localhost:8080/toll/bus" );
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void whenRequestBusIsExecuted_thenDefaultResponseContentTypeIsText(){
        String textMimeType = "text/plain";
        String mimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
        Assert.assertEquals( textMimeType , mimeType );
    }

}
