package org.cayo.handson.restful.vo;

import java.util.Set;

import org.cayo.handson.restful.model.Image;
import org.cayo.handson.restful.model.Product;

public class ProductVO extends AbstractBaseVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String description;

	private ProductVO parent;

	private Set<Image> imagens;

	public static ProductVO getInstace(Product entity, boolean loadParent, boolean loadImages) {
		if(entity == null) {
			return null;
		}
		ProductVO vo = new ProductVO();
		vo.setId(entity.getId());
		vo.setDescription(entity.getDescription());
		vo.setName(entity.getName());
		vo.setParent((loadParent)?ProductVO.getInstace(entity.getParent(), false, false):null);
		vo.setImagens((loadImages)?null:null);
		return vo;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	public ProductVO getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(ProductVO parent) {
		this.parent = parent;
	}

	/**
	 * @return the imagens
	 */
	public Set<Image> getImagens() {
		return imagens;
	}

	/**
	 * @param imagens the imagens to set
	 */
	public void setImagens(Set<Image> imagens) {
		this.imagens = imagens;
	}

}
