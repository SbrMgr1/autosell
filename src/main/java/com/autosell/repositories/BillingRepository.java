package com.autosell.repositories;

import com.autosell.domains.BillingAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends CrudRepository<BillingAddress, Long> {
    public List<BillingAddress> findAll();
    public BillingAddress findById(long id);
}
