package com.springboot.app.javatars.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;

public record UsuarioDTO(
        Long id,

        @NotEmpty
        @Length(min = 5, max = 20)
        String nombre,

        @NotEmpty
        @Email
        String correo,

        @NotEmpty
        @Length(min = 8, max = 20)
        String contrasena,

        @NotEmpty
        @Length(min = 7, max = 10)
        String telefono,

        @NotEmpty
        @Length(min = 5, max = 20)
        String direccion,

        Timestamp createdAt
) {
}
