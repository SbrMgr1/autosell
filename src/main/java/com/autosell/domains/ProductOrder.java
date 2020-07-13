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

    private Long product_id;
    private Double product_price;
    private Integer product_qty;
    private Long transaction_id;
    private float product_tax;
    private Long buyer_id;
    private String order_status;
    private Long address_id;



//    @OneToMany(cascade = CascadeType.ALL)
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn
//    private List<Product> products;

    public ProductOrder() {
    }

    public Long getId() {
        return id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public Integer getProduct_qty() {
        return product_qty;
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public float getProduct_tax() {
        return product_tax;
    }

    public Long getBuyer_id() {
        return buyer_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public void setProduct_qty(Integer product_qty) {
        this.product_qty = product_qty;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public void setProduct_tax(float product_tax) {
        this.product_tax = product_tax;
    }

    public void setBuyer_id(Long buyer_id) {
        this.buyer_id = buyer_id;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
}
