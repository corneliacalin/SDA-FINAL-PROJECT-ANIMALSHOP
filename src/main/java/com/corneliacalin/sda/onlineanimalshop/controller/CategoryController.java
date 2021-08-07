package com.corneliacalin.sda.onlineanimalshop.controller;

import com.corneliacalin.sda.onlineanimalshop.service.CategoryService;
import com.corneliacalin.sda.onlineanimalshop.service.ProductService;
import com.corneliacalin.sda.onlineanimalshop.service.dto.CategoryDTO;
import com.corneliacalin.sda.onlineanimalshop.service.dto.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller

public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping("/category-list")
    public String showCategoryListPage(Model model) {

        model.addAttribute("categories", categoryService.getAllRoot());
        return "category-list"; // numele de la html
    }
//    //        List<Product> products =productService.findAll();
////        List<Category> categories=productService.findAll().stream()
////                .map(product->product.getCategory()).collect(Collectors.toList());
////        model.addAttribute("categories", categories);


    @GetMapping("/add-category")
    public String addProduct(Model model) {
        model.addAttribute("category", new CategoryDTO());
        model.addAttribute("categories", categoryService.getAll());
        // model.addAttribute("categories", productService.getAll().stream().map(product->product.getCategory()).filter(product-> product !=null).distinct().collect(Collectors.toList()))  ;
        return "category-add";
    }
//
//    @PostMapping("/addcategory")
//    public String saveCategory(@ModelAttribute("category")@Valid CategoryDTO categoryDTO, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()){
//            return "product-add";
//        }
//        productService.save(productDTO);
//        return "redirect:/product-list";
//    }
}