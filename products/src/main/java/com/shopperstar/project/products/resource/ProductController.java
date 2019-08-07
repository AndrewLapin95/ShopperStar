package com.shopperstar.project.products.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shopperstar.project.products.model.ElasticSearchProductMapping;
import com.shopperstar.project.products.model.Product;
import com.shopperstar.project.products.repository.ElasticSearchProductRepository;
import com.shopperstar.project.products.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ElasticSearchProductRepository elasticsearchRepository;
	
	@Autowired
	private ProductRepository repository;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@PostMapping("/api/create-product")
	public String createProduct(@Valid @RequestBody Product newProduct) {
		
		Product savedProduct = null;
		
		try {
			
			logger.info("Creating new product :" + newProduct.getTitle() + " in the database");
			savedProduct = repository.save(newProduct);
			
		} catch (Exception ex) {
			
			logger.error("Failed to create new product: " + newProduct.getTitle() + " in the database");
			logger.error(ex.toString());
		}
		
		ElasticSearchProductMapping newMapping = savedProduct.convertFromProduct();
		
		try {
			
			logger.info("Creating new product: " + newMapping.getTitle() + " in the elasticsearch cluster");
			elasticsearchRepository.save(newMapping);
			
		} catch (Exception ex) {
			
			logger.error("Failed to create new product: " + newMapping.getTitle() + " in the elasticsearch cluster");
			logger.error(ex.toString());
		}
		
		return savedProduct.getId();
		
	}
	
	@GetMapping("/api/get-products")
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
	
	@GetMapping("/api/get-product/{id}")
	public Optional<Product> getProduct(@PathVariable String id) {
		
		Optional<Product> foundProduct = repository.findById(id);
		
		if (!foundProduct.isPresent()) {
			throw new ProductNotFoundException("ID: " + id);
		}
		
		return foundProduct;
	}
	
	@DeleteMapping("/api/remove-product/{id}")
	public ResponseEntity<Product> removeProduct(@PathVariable String id) {
		
		Product deletedProduct = getProduct(id).get();
		
		try {
			
			logger.info("Attempting to delete product: " + id + " from the database");
			repository.deleteById(id);
			logger.info("Successfully deleted product with id: " + id + " from the database");
			
		} catch (Exception ex) {
			
			logger.error("Failed to delete product: " + id);
			logger.error(ex.toString());
			
		}
		
		try {
			
			logger.info("Attempting to delete product: " + id + " from the cluster");
			elasticsearchRepository.deleteById(id);
			logger.info("Successfully deleted product with id: " + id + "from the cluster");
			
		} catch (Exception ex) {
			
			logger.error("Failed to delete product: " + id);
			logger.error(ex.toString());
			
		}
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				  								  .buildAndExpand(deletedProduct.getId())
				  								  .toUri();

		return ResponseEntity.created(location).build();
	}
}
