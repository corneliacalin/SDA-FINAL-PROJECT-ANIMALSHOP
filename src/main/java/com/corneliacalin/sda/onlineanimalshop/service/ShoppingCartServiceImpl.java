package com.corneliacalin.sda.onlineanimalshop.service;



import com.corneliacalin.sda.onlineanimalshop.model.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService
{
    private Map<Product, Integer> cart = new LinkedHashMap<>();

    @Override
    public void addProduct(Product product)
    {
        if (cart.containsKey(product))
        {
            cart.replace(product, cart.get(product) + 1);
        } else
        {
            cart.put(product, 1);
        }
    }

    @Override
    public void removeProduct(Product product)
    {
        if (cart.containsKey(product))
        {
            if (cart.get(product) > 1)
                cart.replace(product, cart.get(product) - 1);
            else if (cart.get(product) == 1)
            {
                cart.remove(product);
            }
        }
    }

    @Override
    public void clearProducts()
    {
        cart.clear();
    }

    @Override
    public Map<Product, Integer> productsInCart()
    {
        return Collections.unmodifiableMap(cart);
    }

    @Override
    public BigDecimal totalPrice()
    {
        return cart.entrySet().stream()
                .map(k -> k.getKey().getPrice().multiply(BigDecimal.valueOf(k.getValue()))).sorted()
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public void cartCheckout()
    {

// de aici de modif
//
//
//        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Account account = accountRepository.findByEmail(principal.getUsername());
//        Customer customer = customerRepository.findByAccount_Id(account.getId());
//
//        Bill bill = new Bill();
//        double price = 0;
//
//        //create order
//        Order order = new Order();
//        order.setCreationDate(Timestamp.from(Instant.now()));
//        order.setOrderStatus(OrderStatus.NEW);
//        //info from customer
//        order.setCustomer(customer);
//        order.setAddress(customer.getAddress());
//
//
//        orderRepository.save(order);
//
//        //create orderLines
//        List<OrderLine> orderLines = new ArrayList<>();
//        for (Map.Entry<Food, Integer> foodIntegerEntry : cart.entrySet()) {
//
//
//            //create orderLine
//            OrderLine orderLine = new OrderLine();
//            orderLine.setFood(foodIntegerEntry.getKey());
//            orderLine.setQuantity(foodIntegerEntry.getValue());
//            orderLine.setPrice((foodIntegerEntry.getValue() * foodIntegerEntry.getKey().getPrice().doubleValue()));
//
//
//            // add orderLine to orderLines
//            orderLine.setOrder(order);
//
//            // save orderLine
//            orderLineRepository.save(orderLine);
//
//            price += orderLine.getPrice();
//        }
//
//        bill.setCurrency("RON");
//        bill.setIssueDate(Timestamp.from(Instant.now()));
//        bill.setTotalPrice(price);
//        bill.setDueDate(null);
//        billRepository.save(bill);
//        order.setBill(bill);
//
//        //save order in repository
//        orderRepository.save(order);
//pana aici




        cart.clear();
        // Normally there would be payment etc.
    }
}
