package org.acme.kogito.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.acme.kogito.model.Hello;

@Path("/hello")
public interface HelloWorld {

    @GET
    Hello hello();
}
