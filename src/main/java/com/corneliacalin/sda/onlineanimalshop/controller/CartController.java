package com.corneliacalin.sda.onlineanimalshop.controller;


import com.corneliacalin.sda.onlineanimalshop.model.Product;
import com.corneliacalin.sda.onlineanimalshop.service.ProductService;
import com.corneliacalin.sda.onlineanimalshop.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController
{
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;

    @Autowired
    public CartController(ShoppingCartService shoppingCartService, ProductService productService)
    {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @GetMapping("/cart")
    public String cart(Model model)
    {
        model.addAttribute("products", shoppingCartService.productsInCart());
        model.addAttribute("totalPrice", shoppingCartService.totalPrice());

        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addProductToCart(@PathVariable("id") long id)
    {
        Product product = productService.findById(id).orElse(null);
        if (product != null)
        {
            shoppingCartService.addProduct(product);
        }
        return "redirect:/home";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeProductFromCart(@PathVariable("id") long id)
    {
        Product product = productService.findById(id).orElse(null);
        if (product != null)
        {
            shoppingCartService.removeProduct(product);
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearProductsInCart()
    {
        shoppingCartService.clearProducts();

        return "redirect:/cart";
    }

    @GetMapping("/cart/checkout")
    public String cartCheckout()
    {
        shoppingCartService.cartCheckout();
        return "redirect:/cart";
    }
}
