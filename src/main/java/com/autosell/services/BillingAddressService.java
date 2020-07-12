package com.autosell.services;

import com.autosell.domains.BillingAddress;
import com.autosell.repositories.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BillingAddressService {
    @Autowired
    BillingRepository billingRepository;

    public BillingAddress save(BillingAddress billingAddress){
        return billingRepository.save(billingAddress);
    }
}
