package com.corneliacalin.sda.onlineanimalshop.service;

import com.corneliacalin.sda.onlineanimalshop.model.Product;
import com.corneliacalin.sda.onlineanimalshop.repository.CategoryRepository;
import com.corneliacalin.sda.onlineanimalshop.repository.ProductRepository;
import com.corneliacalin.sda.onlineanimalshop.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Transactional

    public void save(Product product){
        productRepository.save(product);


    }
    public List<Product> getAll(){  // getAll

    return new ArrayList<Product>((Collection<? extends Product>) productRepository.findAll());
//        return StreamSupport.stream(productRepository.findAll().spliterator(),false).collect(Collectors.toList());


    }

    public Optional<Product> findById(Long productId){
        return productRepository.findById(productId);

    }

    public void save (ProductDTO productDTO){
        Product product = new Product ();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());

        product.setThumbnail(productDTO.getThumbnail());
        product.setCategory(categoryRepository.findById(productDTO.getProductCategoryId()).orElse(null));
        productRepository.save(product);

    }
}
