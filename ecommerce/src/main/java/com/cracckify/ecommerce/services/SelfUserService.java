package com.cracckify.ecommerce.services;

import com.cracckify.ecommerce.models.User;
import com.cracckify.ecommerce.models.User;
import com.cracckify.ecommerce.repositories.SelfUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfUserService implements UserService{

    @Autowired
    SelfUserRepository selfUserRepository;

    @Override
    public User getUserById(Long id) {
        return selfUserRepository.getUserById(id);
    }

    public User createUser(User user) {

        return selfUserRepository.createUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}