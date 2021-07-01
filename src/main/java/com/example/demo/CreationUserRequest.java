package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreationUserRequest {
        private int id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String phone;
        private int userStatus;
}
