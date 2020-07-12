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

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
}
