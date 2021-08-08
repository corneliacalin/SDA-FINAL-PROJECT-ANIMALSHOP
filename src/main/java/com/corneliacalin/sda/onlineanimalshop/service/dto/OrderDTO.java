package com.corneliacalin.sda.onlineanimalshop.service.dto;

import com.corneliacalin.sda.onlineanimalshop.model.Customer;
import com.corneliacalin.sda.onlineanimalshop.model.OrderLine;
import com.corneliacalin.sda.onlineanimalshop.model.OrderStatus;

import java.sql.Timestamp;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Customer customer;
    private Double totalCost;
    private String deliveryAddress;
    private Timestamp dateOfOrder;
    private List<OrderLine> orderLines;
    private OrderStatus status;

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Timestamp getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Timestamp dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
