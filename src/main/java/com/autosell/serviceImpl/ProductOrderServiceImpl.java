package com.autosell.serviceImpl;


import com.autosell.domains.ProductOrder;
import com.autosell.repositories.ProductOrderRepository;
import com.autosell.services.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    @Autowired
    ProductOrderRepository productOrderRepository;

    @Override
    public ProductOrder save(ProductOrder productOrder) {
        return productOrderRepository.save(productOrder);
    }

    @Override
    public List<ProductOrder> findAll() {
        return (List<ProductOrder>) productOrderRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        productOrderRepository.deleteById(id);
    }

    @Override
    public ProductOrder find(long id){
        return productOrderRepository.findById(id).get();
    }
}
