package com.bst.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bst.products.model.Products;
@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

	List<Products> findByUserid(Long userid);

}
