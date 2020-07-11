package com.autosell.serviceImpl;

import com.autosell.domains.Product;
import com.autosell.repositories.ProductRepository;
import com.autosell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }
}
