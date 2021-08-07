package com.corneliacalin.sda.onlineanimalshop.model;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "shop_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "total_cost")
    private Double totalCost;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "date_of_order")
    private Timestamp creationDate;

    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderlines;



    @Column(name = "order_status")
    private OrderStatus orderStatus;

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

    public List<OrderLine> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<OrderLine> orderlines) {
        this.orderlines = orderlines;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", totalCost=" + totalCost +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", creationDate=" + creationDate +
                ", orderlines=" + orderlines +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
