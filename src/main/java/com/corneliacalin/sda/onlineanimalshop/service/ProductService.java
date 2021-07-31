package com.corneliacalin.sda.onlineanimalshop.service;

import com.corneliacalin.sda.onlineanimalshop.model.Product;
import com.corneliacalin.sda.onlineanimalshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Transactional
    public void save(Product product){
        productRepository.save(product);


    }
    public List<Product> findAll(){

//    return new ArrayList<Product>((Collection<? extends Product>) productRepository.findAll());
        return StreamSupport.stream(productRepository.findAll().spliterator(),false).collect(Collectors.toList());


    }

    public Optional<Product> findById(Long productId){
        return productRepository.findById(productId);

    }
}
