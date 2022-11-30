package com.forgeeks.SpringDZ5.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
