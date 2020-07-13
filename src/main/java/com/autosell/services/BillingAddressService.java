package com.autosell.services;

import com.autosell.domains.BillingAddress;
import com.autosell.repositories.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface BillingAddressService {

    public BillingAddress save(BillingAddress billingAddress);
    public List<BillingAddress> getAllBillingAddress();

    public BillingAddress findById(long id);

    public void delete(BillingAddress billingAddress);
}
