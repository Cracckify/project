package com.crackify.ecommerce.controller;


import com.crackify.ecommerce.DTOs.ApiResponse;
import com.crackify.ecommerce.DTOs.LoginRequestDto;
import com.crackify.ecommerce.DTOs.UserRequestDto;
import com.crackify.ecommerce.DTOs.UserResponseDto;
import com.crackify.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Create user
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@RequestBody UserRequestDto dto) {
        UserResponseDto user = userService.createUser(dto);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "User created successfully", user)
        );
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUser(@PathVariable Long id) {
        UserResponseDto user = userService.getUserById(id);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "User fetched successfully", user)
        );
    }

    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> updateUser(@PathVariable Long id,
                                                                   @RequestBody UserRequestDto dto) {
        UserResponseDto updated = userService.updateUser(id, dto);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "User updated successfully", updated)
        );
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        return ResponseEntity.ok(
                new ApiResponse<>(deleted, deleted ? "User deleted" : "User not found", deleted)
        );
    }

    // Login user
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody LoginRequestDto dto) {
        String token = userService.login(dto);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Login successful", token)
        );
    }
}
