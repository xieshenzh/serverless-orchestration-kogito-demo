package org.acme.kogito.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.acme.kogito.model.Result;

@Path("/save")
public interface SaveResult {

    @POST
    void save(Result result);
}
