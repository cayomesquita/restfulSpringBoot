package org.cayo.handson.restful.persistence.repository;

import java.util.List;

import org.cayo.handson.restful.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);

	@Query(value = "SELECT * FROM PRODUCT p WHERE p.ID_PARENT = ?1", nativeQuery = true)
	List<Product> findChildrenByIdParent(Integer id);
}
