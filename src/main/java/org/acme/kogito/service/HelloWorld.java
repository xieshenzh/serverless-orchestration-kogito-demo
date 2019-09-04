package org.acme.kogito.service;

import java.net.URI;
import java.net.URISyntaxException;

import javax.enterprise.context.ApplicationScoped;

import org.acme.kogito.model.Hello;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class HelloWorld {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

    private static final String SERVICE = "helloworld";
    private static final String URL = "svc.cluster.local";
//    private static final String PATH = "hello";
    private static final String NAMESPACE = System.getenv("POD_NAMESPACE");

    public Hello hello(String h)  {
        String url = "http://" + SERVICE + "." + NAMESPACE + "." + URL;
        LOGGER.info("URL: " + url);

        try {
            URI apiUri = new URI(url);

            org.acme.kogito.rest.HelloWorld service = RestClientBuilder.newBuilder()
                    .baseUri(apiUri)
                    .build(org.acme.kogito.rest.HelloWorld.class);

            return service.hello();
        } catch (URISyntaxException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return null;
    }
}
