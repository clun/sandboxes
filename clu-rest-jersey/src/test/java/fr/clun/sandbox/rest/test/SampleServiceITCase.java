package fr.clun.sandbox.rest.test;

import javax.ws.rs.core.UriBuilder;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SampleServiceITCase {

    @Test
    public void testHello() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/sandbox-rest-jersey/ws")
                .build());
        String response = service.path("say").path("hello").accept(MediaType.TEXT_PLAIN_VALUE).get(String.class);
        Assert.assertEquals(response, "Hello World");
        System.out.println("== Mon Test d'integration est OK");
    }
}
