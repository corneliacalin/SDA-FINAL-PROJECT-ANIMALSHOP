package com.corneliacalin.sda.onlineanimalshop.service;

import com.corneliacalin.sda.onlineanimalshop.model.Category;

import com.corneliacalin.sda.onlineanimalshop.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }

    public List<Category> getAll() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public List<Category> getAllRoot() {
        return StreamSupport.stream(categoryRepository.findAllByParentIsNull().spliterator(), false).collect(Collectors.toList());
    }
}
