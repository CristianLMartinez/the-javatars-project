package com.springboot.app.javatars.dto;

import java.sql.Timestamp;

public record UsuarioDTO(
        Long id,
        String nombre,
        String correo,
        String contrasena,
        String telefono,
        String direccion,
        Timestamp createdAt
) {}
