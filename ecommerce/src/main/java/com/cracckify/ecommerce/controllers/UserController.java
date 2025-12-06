package com.cracckify.ecommerce.controllers;

import com.cracckify.ecommerce.models.User;
import com.cracckify.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

//    private final UserService service;

//    public UserController(UserService service) {
//        this.service = service;
//    }

    @Autowired
    @Qualifier("externalUserService")
    UserService userService;

    // READ - ONE
    @GetMapping("/get/{id}")
    public User getUser(@PathVariable Long id) {return userService.getUserById(id);}
    
    // READ - ALL
    @GetMapping("/")
    public List<User> getAllUsers() {return userService.getAllUsers();}
    
    // CREATE
    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        System.out.println("Created user: " + user.getId());
        return "User created: " + user.getUserId();
    }




//    // UPDATE
//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable Long id, @RequestBody User user) {
//        return service.updateUser(id, user);
//    }
//
//    // DELETE
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable Long id) {
//        service.deleteUser(id);
//        return "User deleted successfully";
//    }
}
