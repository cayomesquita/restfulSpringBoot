package org.cayo.handson.restful.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class HelloEndpoint {

    @GET
    @Produces("application/json")
    public String hello() {
        return "Hello World!";
    }

}
