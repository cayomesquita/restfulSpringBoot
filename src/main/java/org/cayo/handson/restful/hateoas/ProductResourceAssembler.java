package org.cayo.handson.restful.hateoas;

import org.cayo.handson.restful.endpoints.ProductEndpoint;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ProductResourceAssembler extends ResourceAssemblerSupport<ProductResource, ProductResource> {

	public ProductResourceAssembler() {
		super(ProductEndpoint.class, ProductResource.class);
	}

	@Override
	public ProductResource toResource(ProductResource entity) {
		ProductResource resource = instantiateResource(entity);
		resource.description = entity.getDescription();
		resource.name = entity.getDescription();
		resource.parent = (entity.getParent() == null) ? null : new ProductResourceAssembler().toResource(entity.getParent());
		// resource.imagens = new ImageResourceAssembler().toResource(entity.getImages());
		return resource;
	}

}
