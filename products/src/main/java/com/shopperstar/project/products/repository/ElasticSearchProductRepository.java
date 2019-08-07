package com.shopperstar.project.products.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.shopperstar.project.products.model.ElasticSearchProductMapping;

public interface ElasticSearchProductRepository extends ElasticsearchRepository<ElasticSearchProductMapping, String>{

}
