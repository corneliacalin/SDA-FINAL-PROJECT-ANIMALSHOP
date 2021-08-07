package com.corneliacalin.sda.onlineanimalshop.repository;

import com.corneliacalin.sda.onlineanimalshop.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {


}
