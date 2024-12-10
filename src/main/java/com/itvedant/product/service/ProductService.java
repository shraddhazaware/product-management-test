package com.itvedant.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.product.ProductRepository;
import com.itvedant.product.dao.AddProductDao;
import com.itvedant.product.dao.UpdateProductDao;
import com.itvedant.product.entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public Product addProduct(AddProductDao addProductDao) {
		Product product = new Product();
		
		product.setName(addProductDao.getName());
		product.setPrice(addProductDao.getPrice());
		product.setQuantity(addProductDao.getQuantity());
		
		this.productRepository.save(product);
		
		return product;
	}
	
	public List<Product> readAll(){
		List<Product> product=new ArrayList<Product>();
		product =this.productRepository.findAll();
		
		return product;
	}
	
	public Product readById(Integer id) {
		Product product =new Product();
		product=this.productRepository.findById(id).orElse(null);
		return product;
	}
	
	public Product updateProduct(Integer id,UpdateProductDao updateProductDao) {
		Product product =new Product();
		
		product =this.readById(id);
		if(updateProductDao.getName() != null) {
			product.setName(updateProductDao.getName());
		}
		
		if(updateProductDao.getPrice() !=null) {
			product.setPrice(updateProductDao.getPrice());
	}
	
			
		if(updateProductDao.getQuantity() != null) {
			product.setQuantity(updateProductDao.getQuantity());
		}
			
			this.productRepository.save(product);
	
		
		return product;
	}
	
	public String deleteProduct(Integer id) {
		Product product =new Product();
		product=this.readById(id);
		this.productRepository.delete(product);
		return "Product has been deleted successfully";
	}
}
