package com.autosell.serviceImpl;

import com.autosell.domains.ShippingAddress;
import com.autosell.repositories.ShippingAddressRepository;
import com.autosell.services.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ShippingAddresImpl implements ShippingAddressService {
    @Autowired
    ShippingAddressRepository shippingAddressRepository;


    @Override
    public ShippingAddress save(ShippingAddress shippingAddress){
        return shippingAddressRepository.save(shippingAddress);
    }
    @Override
    public List<ShippingAddress> getAllShippingAddress(){
        return shippingAddressRepository.findAll();
    }

    @Override
    public ShippingAddress findById(long id) {
        return shippingAddressRepository.findById(id);
    }
    @Override
    public void delete(ShippingAddress shippingAddress) {
        shippingAddressRepository.delete(shippingAddress);
    }
}
