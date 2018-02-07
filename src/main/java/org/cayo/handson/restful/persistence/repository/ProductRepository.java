package org.cayo.handson.restful.persistence.repository;

import org.cayo.handson.restful.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
