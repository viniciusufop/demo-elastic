package com.example.demoelastic.repository;

import com.example.demoelastic.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @author mustley
 * @version $Revision: $<br/>
 * $Id: $
 * @since 07/03/19 13:56
 */
public interface ProductRepository extends ElasticsearchCrudRepository<Product, String> {

    Iterable<Product> findAllByNameLike(String name);
}
