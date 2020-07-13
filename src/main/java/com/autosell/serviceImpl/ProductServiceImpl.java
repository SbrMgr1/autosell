package com.autosell.serviceImpl;

import com.autosell.domains.Product;
import com.autosell.repositories.ProductRepository;
import com.autosell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> findAllByAddedBy(Long id) {
        return productRepository.findAllByAddedBy(id);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }
}
