package org.acme.kogito.service;

import javax.enterprise.context.ApplicationScoped;
import org.acme.kogito.model.Hello;
import org.acme.kogito.model.Result;

@ApplicationScoped
public class UpdateArg {

	public Result updateArg(Hello hello) {
		return new Result();
	}
}
