package com.bst.products.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bst.products.service.ProductsService;
import com.bst.products.exception.ResourceNotFoundException;
//import com.bst.products.exception.ResourceNotFoundException;
import com.bst.products.model.Products;
import com.bst.products.repository.ProductsRepository;

@RestController
@RequestMapping("products")
public class ProductsController {

    @Autowired
    ProductsRepository repository;
	
	@Autowired
	ProductsService service;
	
	@GetMapping("/")
	public List<Products> getAllProducts()
	{
		return service.getAll();
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<List<Products>> getproductsByUserid(@PathVariable Long userid )
 	{ List<Products> pro =  repository.findByUserid(userid);
 	  return ResponseEntity.ok(pro);
		
 	}
	
	@PostMapping("/save")
	public String saveProduct(@RequestBody Products product)
	{ repository.save(product);
	  return "Product Added Successfully !!"; }
	
	@PostMapping("/search/{pid}")
	public String updateProduct(@PathVariable Long pid,@RequestBody Products product)
	{   Products pro=repository.findById(pid).orElseThrow(()->new ResourceNotFoundException("Not Found"));
		//pro.setPid(product.getPid());
	    pro.setProductname(product.getProductname());
		pro.setQty(product.getQty());
		pro.setPrice(product.getPrice());
		pro.setUserid(product.getUserid());
		repository.save(pro);
	    
		return "Updation Done Successfully !!";
	}
	
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable Long pid)
	{   
		Products pro =repository.findById(pid).orElseThrow(()->new ResourceNotFoundException("Not Found"));
		repository.delete(pro);
		Map<String,Boolean> response = new HashMap<>();
		response.put("delete",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
