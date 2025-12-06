package com.cracckify.ecommerce.repositories;

import com.cracckify.ecommerce.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private Map<Long, User> userDb = new HashMap<>();

    public List<User> findAll() {
        return new ArrayList<>(userDb.values());
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userDb.get(id));
    }

    public User save(User user) {
        userDb.put(user.getId(), user);
        return user;
    }

    public void deleteById(Long id) {
        userDb.remove(id);
    }
}
