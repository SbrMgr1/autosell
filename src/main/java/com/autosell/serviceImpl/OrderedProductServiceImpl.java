package com.autosell.serviceImpl;

import com.autosell.domains.OrderedProduct;
import com.autosell.repositories.OrderedProductRepository;
import com.autosell.services.OrderedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderedProductServiceImpl implements OrderedProductService {

    @Autowired
    OrderedProductRepository orderedProductRepository;

    @Override
    public OrderedProduct findByProductId(Long id) {
        return orderedProductRepository.findByProductId(id);
    }
}
