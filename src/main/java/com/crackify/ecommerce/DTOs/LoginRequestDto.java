package com.crackify.ecommerce.DTOs;

import lombok.*;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}
