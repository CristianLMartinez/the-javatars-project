package com.springboot.app.javatars.controller;

import com.springboot.app.javatars.dto.UsuarioDTO;
import com.springboot.app.javatars.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{correo}")
    public UsuarioDTO obtenerPorCorreo(@PathVariable String correo) {
        return usuarioService.obtenerPorcorreo(correo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO crearUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) { // response entity
        return usuarioService.crearUsuario(usuarioDTO);
    }


}
