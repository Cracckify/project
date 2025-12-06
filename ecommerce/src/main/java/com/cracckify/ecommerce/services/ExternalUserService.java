package com.cracckify.ecommerce.services;

import com.cracckify.ecommerce.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExternalUserService implements UserService{

    public static final String BASE_URL = "https://fakestoreapi.com/users/";

    @Autowired
    RestTemplate restTemplateConfiguration;


    ExternalUserService(){
    }

    @Override
    public User getUserById(Long id) {
        String url = BASE_URL + id;
        ResponseEntity<User> p1 = restTemplateConfiguration.getForEntity(url, User.class);
        System.out.println(p1);
        return p1.getBody();
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = List.of(restTemplateConfiguration.getForObject(BASE_URL, User[].class));
        return users;
    }
}
