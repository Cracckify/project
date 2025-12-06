package com.cracckify.ecommerce.models;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    private Long id;
    private int userId;
    private List<Product> products;
}
