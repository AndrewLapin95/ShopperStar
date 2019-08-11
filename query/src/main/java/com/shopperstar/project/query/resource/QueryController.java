package com.shopperstar.project.query.resource;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shopperstar.project.query.model.SearchedProduct;
import com.shopperstar.project.query.repository.ElasticSearchRepository;

@RestController
public class QueryController {
	
	@Autowired
	private ElasticSearchRepository repository;
	
	@GetMapping("/api/get-products")
	public List<SearchedProduct> getAllProducts() {
		return repository.findAll();
	}
	
	@GetMapping("/api/get-products-by-category/{category}")
	public List<SearchedProduct> getProductsByCategory(@PathVariable String category) {
		QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("category", category.toUpperCase()));
		return repository.search(query);
	}
	
	@GetMapping("/api/get-products-by-title/{title}")
	public List<SearchedProduct> getProductsByTitle(@PathVariable String title) {
		QueryBuilder query = QueryBuilders.commonTermsQuery("title", title);
		return repository.search(query);
	}
	
	@GetMapping("/api/search-products/{entry}")
	public List<SearchedProduct> searchProducts(@PathVariable String entry) {
		
		QueryBuilder query = QueryBuilders.boolQuery()
				.should(QueryBuilders.commonTermsQuery("title", entry))
				.should(QueryBuilders.commonTermsQuery("category", entry))
				.minimumShouldMatch(1);
		
		return repository.search(query);
	}
}
