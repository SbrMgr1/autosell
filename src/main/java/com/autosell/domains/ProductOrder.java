package com.autosell.domains;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long transaction_id;
    @OneToOne
    @JoinColumn(name="buyer_id",nullable = false)
    private User buyer;
    private String order_status;
    @OneToOne
    @JoinColumn(name="bAddr_id",nullable = false)
    private BillingAddress billingAddress;
    @JoinColumn(name="sAddr_id",nullable = false)
    @OneToOne
    private ShippingAddress shippingAddress;

    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<OrderdProduct> products;

    public ProductOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<OrderdProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderdProduct> products) {
        this.products = products;
    }
}
