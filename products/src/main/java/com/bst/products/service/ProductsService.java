package com.bst.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bst.products.model.Products;
import com.bst.products.repository.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository repository;
	
	public List<Products> getAll()
	{
		return repository.findAll();
	}
	

}
