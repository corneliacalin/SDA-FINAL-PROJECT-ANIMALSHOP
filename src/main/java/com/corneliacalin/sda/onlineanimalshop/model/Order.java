package com.corneliacalin.sda.onlineanimalshop.model;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="shop_order")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @OneToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name="total_cost")
    private Double totalCost;

    @Column(name="delivery_address")
    private String deliveryAddress;

    @Column(name="date_of_order")
    private Timestamp creationDate;

    @OneToMany
    @JoinColumn(name="order_line_id")
    private List<OrderLine> orderline;

    @Column (name="status")
    private OrderStatus status;

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

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public List<OrderLine> getOrderline() {
        return orderline;
    }

    public void setOrderline(List<OrderLine> orderline) {
        this.orderline = orderline;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
// status livrata, acceptata, noua enum


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", totalCost=" + totalCost +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", creationDate=" + creationDate +
                ", orderline=" + orderline +
                ", status=" + status +
                '}';
    }
}
