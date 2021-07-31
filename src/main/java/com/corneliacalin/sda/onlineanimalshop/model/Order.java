package com.corneliacalin.sda.onlineanimalshop.model;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="order")
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

    @OneToOne
    @JoinColumn(name="order_line_id")
    private OrderLine orderline;



}
