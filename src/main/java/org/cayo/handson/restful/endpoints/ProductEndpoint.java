package org.cayo.handson.restful.endpoints;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.cayo.handson.restful.model.Product;
import org.cayo.handson.restful.persistence.repository.ProductRepository;
import org.cayo.handson.restful.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Path("/products")
@Produces("application/json")
public class ProductEndpoint {

	@Autowired
	private ProductRepository repository;

	@GET
	@Transactional
	public Response getProducts(@DefaultValue("false") @QueryParam("load-parent") boolean loadParent,
			@DefaultValue("false") @QueryParam("load-image") boolean loadImage) {
		List<ProductVO> result = repository.findAll().stream().map(x -> ProductVO.getInstace(x, loadParent, loadImage))
				.collect(Collectors.toList());
		return Response.ok(result).build();
	}

	@POST
	public Response insertProduct(Product product) {
		if (repository.findByName(product.getName()) != null) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		if (product.getParent() != null && product.getParent().getId() != null) {
			product.setParent(repository.findOne(product.getParent().getId()));
		}
		return Response.ok(repository.save(product).getId()).build();
	}

	@GET
	@Path("/{productId}")
	@Transactional
	public Response getProductById(@PathParam("productId") Integer id,
			@DefaultValue("false") @QueryParam("load-parent") boolean loadParent,
			@DefaultValue("false") @QueryParam("load-image") boolean loadImage) {
		ProductVO vo = ProductVO.getInstace(repository.findOne(id), loadParent, loadImage);
		if(vo == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(vo).build();
	}

	@PUT
	@Path("/{productId}")
	public Response updateProduct(@PathParam("productId") Integer id) {
		return Response.ok(String.format("Product updated (%d)", id)).build();
	}

	@DELETE
	@Path("/{productId}")
	public Response deleteProduct(@PathParam("productId") Integer id) {
		if(repository.exists(id)){
			repository.delete(id);
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

}
