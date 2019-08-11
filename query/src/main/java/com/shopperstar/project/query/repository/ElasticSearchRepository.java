package com.shopperstar.project.query.repository;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.shopperstar.project.query.model.SearchedProduct;

public interface ElasticSearchRepository extends ElasticsearchRepository<SearchedProduct, String>{

	List<SearchedProduct> findAll();
	List<SearchedProduct> search(QueryBuilder query);
	
}