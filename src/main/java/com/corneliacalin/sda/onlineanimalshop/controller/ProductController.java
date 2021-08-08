package com.corneliacalin.sda.onlineanimalshop.controller;

import com.corneliacalin.sda.onlineanimalshop.model.Product;
import com.corneliacalin.sda.onlineanimalshop.service.CategoryService;
import com.corneliacalin.sda.onlineanimalshop.service.ProductService;
import com.corneliacalin.sda.onlineanimalshop.service.dto.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller

public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/product-list")
    public String showProductsListPage(Model model) {

        model.addAttribute("products", productService.getAll());
        return "product-list"; // numele de la html
    }
    //        List<Product> products =productService.findAll();
//        List<Category> categories=productService.findAll().stream()
//                .map(product->product.getCategory()).collect(Collectors.toList());
//        model.addAttribute("categories", categories);


    @GetMapping("/add-product")
    public String addProduct(Model model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("categories", categoryService.getAll());
        return "product-add";
    }

    @PostMapping("/addproduct")
    public String saveProduct(@ModelAttribute("product") @Valid ProductDTO productDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product-add";
        }
        productService.save(productDTO);
        return "redirect:/product-list";
    }

    @GetMapping("/edit-product/{id}")
    public String editProduct(@PathVariable("id") Long productId, Model model) {
        ProductDTO productDTO = productService.findProductDTOById(productId);
        model.addAttribute("product", productDTO);
        model.addAttribute("categories", categoryService.getAll());

        return "product-edit";
    }

    @PostMapping("/editproduct")
    public String editProduct(@ModelAttribute("product") ProductDTO productDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product-edit";
        }
        productService.update(productDTO);
        return "redirect:/product-list";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Long productId) {
        productService.delete(productId);
        return "redirect:/product-list";
    }


//
//    }

//    public List<Product> getAllProducts() {
//        return productService.findAll();
//
//
//    }

//    @GetMapping("/products/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
//        Optional<Product> product = productService.findById(productId);
//        if (product.isPresent()) {
//            return ResponseEntity.ok(product.get());
//        }
////        throw new IllegalArgumentException();
//        throw new ResourceNotFoundException("Product with id: " + productId + " was not found!");
//    }
//
//
//    @PostMapping("/products")
//    public String createProduct(@Valid @RequestBody Product product) {
//        productService.save(product);
//        return "Product saved";
//    }


}