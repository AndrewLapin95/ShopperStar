package com.shopperstar.project.query.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.shopperstar.project.query.model.SearchedProduct;

public interface ElasticSearchRepository extends ElasticsearchRepository<SearchedProduct, String>{

}
