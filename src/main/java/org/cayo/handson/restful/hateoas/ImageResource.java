package org.cayo.handson.restful.hateoas;

import org.cayo.handson.restful.model.Image;

public class ImageResource extends AbstractBaseResource<ImageResource> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idImage;

	private String description;

	public static ImageResource getInstace(Image entity) {
		if (entity == null) {
			return null;
		}
		ImageResource vo = new ImageResource();
		vo.setId(entity.getId());
		vo.setDescription(entity.getDescription());
		return vo;
	}

	/**
	 * @return the idImage
	 */
	public Integer getIdImage() {
		return idImage;
	}

	/**
	 * @param idImage
	 *            the idImage to set
	 */
	public void setId(Integer idImage) {
		this.idImage = idImage;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idImage == null) ? 0 : idImage.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ImageResource))
			return false;
		ImageResource other = (ImageResource) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idImage == null) {
			if (other.idImage != null)
				return false;
		} else if (!idImage.equals(other.idImage))
			return false;
		return true;
	}

	@Override
	public ImageResource generateLinks() {
		// TODO Auto-generated method stub
		return null;
	}

}
