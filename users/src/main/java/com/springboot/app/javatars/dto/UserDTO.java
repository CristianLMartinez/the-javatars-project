package com.springboot.app.javatars.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;

public record UserDTO(
        Long id,

        @NotEmpty
        @Length(min = 5, max = 20)
        String name,

        @NotEmpty
        @Email
        String email,

        @NotEmpty
        @Length(min = 8, max = 20)
        String password,

        @NotEmpty
        @Length(min = 7, max = 10)
        String celphone,

        @NotEmpty
        @Length(min = 5, max = 20)
        String address,

        Timestamp createdAt
) {
        public String getName(){
        return name;
        }

        public String getEmail(){
        return email;
        }

        public String getPassword() {
        return password;
        }

        public String getCelphone() {
        return celphone;
        }

        public String getAddress() {
        return address;
        }
}
