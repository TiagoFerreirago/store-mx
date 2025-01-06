package com.mx.product_catalog.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.mx.product_catalog.model.Product;


public interface ProductRepository extends ElasticsearchRepository<Product, Long> {

}
