package com.autosell.services;

import com.autosell.domains.Product;
import com.autosell.domains.ProductOrder;

import java.util.List;
import java.util.Optional;

public interface ProductOrderService {
    public ProductOrder save(ProductOrder productOrder);
    public List<ProductOrder> findAll();
    public void deleteById(Long id);
    public ProductOrder find(long id);
}
