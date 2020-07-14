package com.autosell.serviceImpl;


import com.autosell.domains.ProductOrder;
import com.autosell.repositories.ProductOrderRepository;
import com.autosell.services.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductOrderServiceImpl implements ProductOrderService {
    @Autowired
    ProductOrderRepository productOrderRepository;

    @Override
    public List<ProductOrder> getAll() {
        return (List<ProductOrder>)productOrderRepository.findAll();
    }

    @Override
    public ProductOrder save(ProductOrder productOrder) {
        return productOrderRepository.save(productOrder);
    }

    @Override
    public ProductOrder get(Long id) {
        return productOrderRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        productOrderRepository.deleteById(id);
    }

}
