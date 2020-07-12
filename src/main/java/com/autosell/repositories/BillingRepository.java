package com.autosell.repositories;

import com.autosell.domains.BillingAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends CrudRepository<BillingAddress, Long> {
//    public BillingAddress save(BillingAddress billingAddress){
//        return
//    }

}
