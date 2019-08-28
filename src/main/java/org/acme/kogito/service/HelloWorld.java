package org.acme.kogito.service;

import javax.enterprise.context.ApplicationScoped;
import org.acme.kogito.model.Hello;

@ApplicationScoped
public class HelloWorld {

	public Hello hello(String hello) {
		Hello h = new Hello();
		h.setPayload("hello");
		return h;
	}
}
