package com.example.demo.model;

import lombok.Data;

/**
 * is used to authenticate via JWT
 */
@Data
public class AuthorizationRequestDTO {

    private String email;
    private String password;
}
