package org.acme.kogito.service;

import javax.enterprise.context.ApplicationScoped;

import org.acme.kogito.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class SaveResult {

    private static final Logger logger = LoggerFactory.getLogger(SaveResult.class);

    public Result saveResult(Result result) {
        logger.info("Result {} is being saved", result.getResult());
        return result;
    }
}
