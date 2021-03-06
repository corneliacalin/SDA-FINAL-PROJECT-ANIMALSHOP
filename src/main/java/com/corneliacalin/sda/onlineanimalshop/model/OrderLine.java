package com.corneliacalin.sda.onlineanimalshop.model;


import javax.persistence.*;

@Entity
@Table(name="order_line")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column (name="quantity")
    private Integer quantity;

    @Column(name="product_price")
    private Double productPrice;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", productPrice=" + productPrice +
                ", order=" + order +
                '}';
    }
}
