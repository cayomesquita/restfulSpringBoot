package org.cayo.handson.restful.persistence.repository;

import java.util.Collection;

import org.cayo.handson.restful.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepository extends JpaRepository<Image, Integer> {

	@Query(value = "SELECT * FROM IMAGE i WHERE i.ID_PRODUCT = ?1" , nativeQuery = true)
	Collection<Image> findAllProductImages(Integer idProduct);

	@Query(value = "SELECT * FROM IMAGE i WHERE i.ID_PRODUCT = ?1 AND i.ID_IMAGE = ?2" , nativeQuery = true)
	Image findOneByProductIdAndImageId(Integer productId, Integer imageId);

}
