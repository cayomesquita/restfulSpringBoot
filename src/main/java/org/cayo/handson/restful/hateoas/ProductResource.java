package org.cayo.handson.restful.hateoas;

import java.util.Set;
import java.util.stream.Collectors;

import org.cayo.handson.restful.model.Product;

public class ProductResource extends AbstractBaseResource<ProductResource>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idProduct;

	private String name;

	private String description;

	private ProductResource parent;

	private Set<ImageResource> imagens;

	public static ProductResource getInstace(Product entity, boolean loadParent, boolean loadImages) {
		if(entity == null) {
			return null;
		}
		ProductResource resource = new ProductResource();
		resource.setIdProduct(entity.getId());
		resource.setDescription(entity.getDescription());
		resource.setName(entity.getName());
		resource.setParent((loadParent)?ProductResource.getInstace(entity.getParent(), false, false):null);
		resource.setImagens((loadImages)?entity.getImagens().stream().map(x->ImageResource.getInstace(x)).collect(Collectors.toSet()):null);
		return resource;
	}
	
	/**
	 * @return the idProduct
	 */
	public Integer getIdProduct() {
		return idProduct;
	}

	/**
	 * @param idProduct the idProduct to set
	 */
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the parent
	 */
	public ProductResource getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(ProductResource parent) {
		this.parent = parent;
	}

	/**
	 * @return the imagens
	 */
	public Set<ImageResource> getImagens() {
		return imagens;
	}

	/**
	 * @param imagens the imagens to set
	 */
	public void setImagens(Set<ImageResource> imagens) {
		this.imagens = imagens;
	}

	@Override
	public ProductResource generateLinks() {
		// TODO Auto-generated method stub
		return null;
	}

}
