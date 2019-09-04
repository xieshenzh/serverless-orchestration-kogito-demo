package org.acme.kogito.service;

import java.net.URI;
import java.net.URISyntaxException;

import javax.enterprise.context.ApplicationScoped;

import org.acme.kogito.model.Result;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class SaveResult {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveResult.class);

    private static final String SERVICE = "saveresults";
    private static final String URL = "svc.cluster.local";
    private static final String PATH = "save";
    private static final String NAMESPACE = System.getenv("POD_NAMESPACE");

    public Result saveResult(Result result) {
        String url = SERVICE + "." + NAMESPACE + "." + URL + "/" + PATH;

        try {
            URI apiUri = new URI(url);

            org.acme.kogito.rest.SaveResult service = RestClientBuilder.newBuilder()
                    .baseUri(apiUri)
                    .build(org.acme.kogito.rest.SaveResult.class);

            service.save(result);
        } catch (URISyntaxException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return result;
    }
}
