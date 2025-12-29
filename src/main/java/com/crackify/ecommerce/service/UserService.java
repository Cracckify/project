package com.crackify.ecommerce.service;


import com.crackify.ecommerce.DTOs.LoginRequestDto;
import com.crackify.ecommerce.DTOs.UserRequestDto;
import com.crackify.ecommerce.DTOs.UserResponseDto;

public interface UserService {

    UserResponseDto createUser(UserRequestDto dto);

    UserResponseDto getUserById(Long id);

    UserResponseDto updateUser(Long id, UserRequestDto dto);

    boolean deleteUser(Long id);

    String login(LoginRequestDto dto);
}
