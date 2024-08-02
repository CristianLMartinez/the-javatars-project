package com.springboot.app.javatars.services;

import com.springboot.app.javatars.dto.UsuarioDTO;
import com.springboot.app.javatars.mapper.UsuarioMapper;
import com.springboot.app.javatars.model.Usuario;
import com.springboot.app.javatars.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarTodos(){
        return usuarioRepository.findAll().stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO obtenerPorcorreo(String correo){
        return UsuarioMapper.toDTO(usuarioRepository.findByCorreo(correo));
    }

    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
        usuario.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        Usuario guardado = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(guardado);
    }


}
