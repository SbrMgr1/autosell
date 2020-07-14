package com.autosell.services;

import com.autosell.domains.Product;
import com.autosell.domains.ProductOrder;

import java.util.List;
import java.util.Optional;

public interface ProductOrderService {

    public List<ProductOrder> getAll();

    public ProductOrder save(ProductOrder productOrder);

    public ProductOrder get(Long id);
    public void deleteById(Long id);
}
