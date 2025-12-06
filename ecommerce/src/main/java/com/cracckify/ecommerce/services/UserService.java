package com.cracckify.ecommerce.services;

import com.cracckify.ecommerce.models.User;

import java.util.List;


public interface UserService {
    public User getUserById(Long id);
    public User createUser(User user);
    public List<User> getAllUsers();
}