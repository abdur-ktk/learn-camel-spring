package com.learn.camel.spring.routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class CamelSimpleRoute extends RouteBuilder {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Environment env;

	@Override
	public void configure() throws Exception {

		log.info("Camel route started....");

		from("{{fromRoute}}")
		.log("What is inside in this file?:: ${body}")
			.log("What enviroment this app using?:: " + env.getProperty("message"))
				.to("{{toRoute1}}");

	}

}
