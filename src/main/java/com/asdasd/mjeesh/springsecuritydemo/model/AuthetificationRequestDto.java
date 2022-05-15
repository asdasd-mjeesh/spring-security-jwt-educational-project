package com.asdasd.mjeesh.springsecuritydemo.model;

import lombok.Data;

@Data
public class AuthetificationRequestDto {
    private String email;
    private String password;
}
