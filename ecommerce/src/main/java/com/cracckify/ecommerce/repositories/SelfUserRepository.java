package com.cracckify.ecommerce.repositories;


import com.cracckify.ecommerce.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class SelfUserRepository {

    HashMap<Long, User> userDB = new HashMap<>();

    public User createUser(User user){
        userDB.put(user.getId(), user);
        return user;
    }

    public User getUserById(Long id){

        return userDB.get(id);
    }
}

