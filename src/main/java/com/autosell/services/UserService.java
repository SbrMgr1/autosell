package com.autosell.services;

import com.autosell.domains.BillingAddress;
import com.autosell.domains.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User findByEmail(String email);
    User findByUserName(String username);
//    List<BillingAddress> saveBillingAddressByID(long id);
    List<User> findAll();
    User FindById(Long id);
    boolean acceptById(Long id);
    boolean declinedById(Long id);
}
