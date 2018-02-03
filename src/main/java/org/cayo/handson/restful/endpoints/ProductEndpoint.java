package org.cayo.handson.restful.endpoints;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.cayo.handson.restful.model.Product;
import org.springframework.stereotype.Component;

@Component
@Path("/products")
@Produces("application/json")
public class ProductEndpoint {

    @GET
    public Response getProducts() {
        return Response.ok("all products").build();
    }
    
    @POST
    public Response insertProduct(Product product) {
    	return Response.ok().build();
    }

    @GET
    @Path("/{productId}")
    public Response getProductById(@PathParam("productId") Integer id) {
        return Response.ok(String.format("Product (%d)", id)).build();
    }
    
    
    @PUT
    @Path("/{productId}")
    public Response updateProduct(@PathParam("productId") Integer id) {
        return Response.ok(String.format("Product updated (%d)", id)).build();
    }
    
    @DELETE
    @Path("/{productId}")
    public Response deleteProduct(@PathParam("productId") Integer id) {
        return Response.ok(String.format("Product deleted (%d)", id)).build();
    }

}
