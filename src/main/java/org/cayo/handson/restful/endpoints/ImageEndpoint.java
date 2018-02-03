package org.cayo.handson.restful.endpoints;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.cayo.handson.restful.model.Image;
import org.springframework.stereotype.Component;

@Component
@Path("/products/{productId}/images")
@Produces("application/json")
public class ImageEndpoint {

    @GET
    public Response getImages() {
        return Response.ok("all products").build();
    }

    @POST
    public Response insertImage(Image Image) {
        return Response.ok().build();
    }
    
    @GET
    @Path("/{imageId}")
    public Response getProductById(@PathParam("productId") Integer productId, @PathParam("imageId") Integer imageId) {
        return Response.ok(String.format("Image add (%d)", imageId)).build();
    }
    
    @PUT
    @Path("/{imageId}")
    public Response updateImage(@PathParam("productId") Integer productId, @PathParam("imageId") Integer imageId) {
        return Response.ok(String.format("Image updated (%d)", imageId)).build();
    }
    
    @DELETE
    @Path("/{imageId}")
    public Response deleteImage(@PathParam("productId") Integer productId, @PathParam("imageId") Integer imageId) {
        return Response.ok(String.format("Image deleted (%d)", imageId)).build();
    }

}
