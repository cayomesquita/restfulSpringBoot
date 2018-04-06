package org.cayo.handson.restful.hateoas;

import org.springframework.hateoas.ResourceSupport;

public abstract class AbstractBaseResource< E extends AbstractBaseResource> extends ResourceSupport {

	public abstract E generateLinks();
}
