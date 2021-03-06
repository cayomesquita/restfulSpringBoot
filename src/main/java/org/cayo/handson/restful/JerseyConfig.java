package org.cayo.handson.restful;

import javax.ws.rs.ApplicationPath;

import org.cayo.handson.restful.endpoints.HelloEndpoint;
import org.cayo.handson.restful.endpoints.ImageEndpoint;
import org.cayo.handson.restful.endpoints.ProductEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(HelloEndpoint.class);
		register(ProductEndpoint.class);
		register(ImageEndpoint.class);
	}

}