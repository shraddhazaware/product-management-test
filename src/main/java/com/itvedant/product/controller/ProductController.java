package com.itvedant.product.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itvedant.product.dao.AddProductDao;
import com.itvedant.product.dao.UpdateProductDao;
import com.itvedant.product.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("")
	public ResponseEntity<?> add(@RequestBody  AddProductDao addProductDao){
		return ResponseEntity.ok(this.productService.addProduct(addProductDao));
	}
	
	@GetMapping("")
	public ResponseEntity<?> readAll(){
		return ResponseEntity.ok(this.productService.readAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> readById(@PathVariable Integer id){
		return ResponseEntity.ok(this.productService.readById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody UpdateProductDao updateProductDao){
		return ResponseEntity.ok(this.productService.updateProduct(id, updateProductDao));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteById(@PathVariable Integer id){
		return ResponseEntity.ok(this.productService.deleteProduct(id));
	}
}
