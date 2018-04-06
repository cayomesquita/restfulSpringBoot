package org.cayo.handson.restful.endpoints;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
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

import org.cayo.handson.restful.hateoas.ProductResource;
import org.cayo.handson.restful.model.Product;
import org.cayo.handson.restful.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Path("/products")
@Produces("application/json")
@Consumes("application/json")
public class ProductEndpoint {

	@Autowired
	private ProductRepository repository;

	@GET
	@Transactional
	public Response getProducts(@DefaultValue("false") @QueryParam("load-parent") boolean loadParent,
			@DefaultValue("false") @QueryParam("load-image") boolean loadImage) {
		List<ProductResource> result = repository.findAll().stream().map(x -> ProductResource.getInstace(x, loadParent, loadImage))
				.collect(Collectors.toList());
		if (result == null) {
			return Response.noContent().build();
		}
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
		ProductResource resource = ProductResource.getInstace(repository.findOne(id), loadParent, loadImage);
		if (resource == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(resource).build();
	}

	@GET
	@Path("/{productId}/children")
	public Response getProductsChildren(@PathParam("productId") Integer id) {
		List<ProductResource> result = repository.findChildrenByIdParent(id).stream()
				.map(x -> ProductResource.getInstace(x, false, false)).collect(Collectors.toList());
		return Response.ok(result).build();
	}

	@PUT
	@Path("/{productId}")
	@Transactional
	public Response updateProduct(Product productInput, @PathParam("productId") Integer id) {
		Product product = repository.findOne(id);
		if (product == null) {
			return insertProduct(productInput);
		} else {
			product.setName(productInput.getName());
			product.setDescription(productInput.getDescription());
			product.setParent(productInput.getParent());
			product.getImagens().clear();
			product.getImagens().addAll(productInput.getImagens());
			repository.save(product);
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/{productId}")
	public Response deleteProduct(@PathParam("productId") Integer id) {
		if (repository.exists(id)) {
			repository.delete(id);
			return Response.noContent().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

}
