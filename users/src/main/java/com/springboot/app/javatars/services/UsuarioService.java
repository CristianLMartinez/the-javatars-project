package com.springboot.app.javatars.services;

import com.springboot.app.javatars.dto.UsuarioDTO;
import com.springboot.app.javatars.mapper.UsuarioMapper;
import com.springboot.app.javatars.model.Usuario;
import com.springboot.app.javatars.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarTodos(){
        return usuarioRepository.findAll().stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO obtenerPorcorreo(String correo){
        return UsuarioMapper.toDTO(usuarioRepository.findByCorreo(correo));
    }

    public UsuarioDTO crearUsuario(String nombre, String correo, String contrasena, String telefono, String direccion) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setContrasena(contrasena);
        usuario.setTelefono(telefono);
        usuario.setDireccion(direccion);
        usuario.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));

        Usuario guardado = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(guardado);
    }

}
