package com.autosell.services;

import com.autosell.domains.ShippingAddress;
import com.autosell.repositories.ShippingAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ShippingAddressService {
    @Autowired
    ShippingAddressRepository shippingAddressRepository;

    public ShippingAddress save(ShippingAddress shippingAddress){
        return shippingAddressRepository.save(shippingAddress);

    }
}
