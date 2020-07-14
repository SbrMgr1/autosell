package com.autosell.services;

import com.autosell.domains.OrderedProduct;

public interface OrderedProductService {

    OrderedProduct findByProductId(Long id);
}
