package com.creativegym.backend.dto;

import com.creativegym.backend.model.Role;
import lombok.Data;

public class AuthDto {

    @Data
    public static class RegisterRequest {
        private String name;
        private String email;
        private String password;
        private String phone;
        private Role role; // Optional, defaults to MEMBER if null
    }

    @Data
    public static class LoginRequest {
        private String email;
        private String password;
    }

    @Data
    public static class AuthResponse {
        private String token;
        private String name;
        private String role;

        public AuthResponse(String token, String name, String role) {
            this.token = token;
            this.name = name;
            this.role = role;
        }
    }
}
