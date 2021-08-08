package com.corneliacalin.sda.onlineanimalshop.service;
import com.corneliacalin.sda.onlineanimalshop.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;


@Service
public interface ShoppingCartService
{
    void addProduct(Product product);

    void removeProduct(Product product);

    void clearProducts();

    Map<Product, Integer> productsInCart();

    BigDecimal totalPrice();

    void cartCheckout();
}
