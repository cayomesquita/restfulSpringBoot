package org.cayo.handson.restful.endpoints;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.cayo.handson.restful.hateoas.ImageResource;
import org.cayo.handson.restful.model.Image;
import org.cayo.handson.restful.model.Product;
import org.cayo.handson.restful.persistence.repository.ImageRepository;
import org.cayo.handson.restful.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Path("/products/{productId}/images")
@Produces("application/json")
@Consumes("application/json")
public class ImageEndpoint {

	@Autowired
	ImageRepository repository;

	@Autowired
	ProductRepository repositoryProduct;

	@GET
	@Transactional
	public Response getProductImages(@PathParam("productId") Integer idProduct) {
		Set<ImageResource> result = repository.findAllProductImages(idProduct).stream().map(x -> ImageResource.getInstace(x))
				.collect(Collectors.toSet());
		if (result.isEmpty()) {
			return Response.noContent().build();
		}
		return Response.ok(result).build();
	}

	@POST
	@Transactional
	public Response insertImage(Image Image, @PathParam("productId") Integer idProduct) {
		Product product = repositoryProduct.findOne(idProduct);
		product.getImagens().add(Image);
		repositoryProduct.save(product);
		return Response.ok().build();
	}

	@GET
	@Path("/{imageId}")
	@Transactional
	public Response getProductById(@PathParam("productId") Integer productId, @PathParam("imageId") Integer imageId) {
		ImageResource result = ImageResource.getInstace(repository.findOneByProductIdAndImageId(productId, imageId));
		if (result == null) {
			return Response.noContent().build();
		}
		return Response.ok(result).build();
	}

	@PUT
	@Path("/{imageId}")
	@Transactional
	public Response updateImage(Image imageInput, @PathParam("productId") Integer productId,
			@PathParam("imageId") Integer imageId) {
		Image image = repository.findOneByProductIdAndImageId(productId, imageId);
		if (image == null) {
			image = repository.findOne(imageId);
			if(image == null) {
				return insertImage(imageInput, productId);
			}else {
				return Response.status(Response.Status.CONFLICT).build();
			}
		} else {
			image.setDescription(imageInput.getDescription());
			repository.save(image);
			return Response.ok().build();
		}
	}

	@DELETE
	@Path("/{imageId}")
	public Response deleteImage(@PathParam("productId") Integer productId, @PathParam("imageId") Integer imageId) {
		if (repository.findOneByProductIdAndImageId(productId, imageId) == null) {
			return Response.noContent().build();
		}
		repository.delete(imageId);
		return Response.ok().build();
	}

}
