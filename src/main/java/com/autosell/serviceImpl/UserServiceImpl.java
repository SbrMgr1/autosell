package com.autosell.serviceImpl;

import com.autosell.domains.User;
import com.autosell.repositories.UserRepository;
import com.autosell.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
