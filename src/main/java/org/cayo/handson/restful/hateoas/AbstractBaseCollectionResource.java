package org.cayo.handson.restful.hateoas;

import java.util.List;

import org.springframework.util.CollectionUtils;

public abstract class AbstractBaseCollectionResource extends AbstractBaseResource<AbstractBaseCollectionResource> {
	
	private List<AbstractBaseResource> content;

	protected void generateContentLinks() {
		if(CollectionUtils.isEmpty(getContent())) {
			getContent().forEach(item->item.generateLinks());
		}
	}

	/**
	 * @return the content
	 */
	protected List<AbstractBaseResource> getContent() {
		return content;
	}

	/**
	 * @param content the content to List
	 */
	protected void setContent(List<AbstractBaseResource> content) {
		this.content = content;
	}
	
}
