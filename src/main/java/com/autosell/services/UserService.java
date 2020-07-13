package com.autosell.services;

import com.autosell.domains.User;

public interface UserService {
    User save(User user);
    User findByEmail(String email);
    User findByUserName(String username);
}
