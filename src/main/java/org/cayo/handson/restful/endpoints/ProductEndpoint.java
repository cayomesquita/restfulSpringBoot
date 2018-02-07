package org.cayo.handson.restful.endpoints;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.cayo.handson.restful.model.Product;
import org.cayo.handson.restful.persistence.repository.ProductRepository;
import org.cayo.handson.restful.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/products")
@Produces("application/json")
public class ProductEndpoint {

	@Autowired
	private ProductRepository repository;
	
    @GET
    public Response getProducts() {
    	List<ProductVO> result = repository.findAll().stream().map(x -> ProductVO.getInstace(x, false, false)).collect(Collectors.toList());
		return Response.ok(result).build();
    }
    
    @POST
    public Response insertProduct(Product product) {
    	return Response.ok(repository.save(product).getId()).build();
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
