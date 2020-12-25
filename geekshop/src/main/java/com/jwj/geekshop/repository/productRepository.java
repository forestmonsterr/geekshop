package com.jwj.geekshop.repository;

import com.jwj.geekshop.model.product;
import org.springframework.data.repository.CrudRepository;

public interface productRepository extends CrudRepository<product, Long> {

}
