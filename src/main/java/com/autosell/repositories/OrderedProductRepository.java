package com.autosell.repositories;

import com.autosell.domains.OrderedProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedProductRepository extends CrudRepository<OrderedProduct,Long> {

    OrderedProduct findByProductId(java.lang.Long id);
}

