package com.autosell.services;

import com.autosell.domains.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product save(Product product);
    public List<Product> findAll();
    public List<Product> findAllByAddedBy(Long id);
    public void deleteById(Long id);

    Optional<Product> findById(long id);
}
