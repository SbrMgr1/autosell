package com.autosell.services;

import com.autosell.domains.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product save(Product product);
    public List<Product> findAll();
    public List<Product> findAllByAddedBy(Long id);
    public void deleteById(Long id);

    Optional<Product> findById(long id);

    public List<Product> updateSoldStatusByIds(List<Long> ids);
}
