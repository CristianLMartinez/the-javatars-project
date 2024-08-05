package com.springboot.app.javatars.mapper;

import com.springboot.app.javatars.dto.UsuarioDTO;
import com.springboot.app.javatars.model.Usuario;

public class UsuarioMapper {

    private UsuarioMapper() throws IllegalAccessException {
        throw new IllegalAccessException("Utility class...");
    }

    public static UsuarioDTO toDTO(Usuario usuario) {
        validUser(usuario);

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getContrasena(),
                usuario.getTelefono(),
                usuario.getDireccion(),
                usuario.getCreatedAt()
        );
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        validUser(dto);

        return new Usuario(
                null,
                dto.nombre(),
                dto.correo(),
                dto.contrasena(),
                dto.telefono(),
                dto.direccion(),
                new java.sql.Timestamp(System.currentTimeMillis()) // Set created_at to current time
        );
    }

    private static void validUser(Object object) {
        if (object == null) {
            throw new RuntimeException("Can convert null object to boolean");
        }
    }


}
