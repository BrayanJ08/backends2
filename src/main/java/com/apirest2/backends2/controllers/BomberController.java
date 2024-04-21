package com.apirest2.backends2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest2.backends2.models.Bomberos;
import com.apirest2.backends2.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Bomberos> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Bomberos obtenerUsuariosPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @PostMapping("/{id}")
    public Bomberos crearBomberos(@RequestBody Bomberos bomberos) {
        return usuarioRepository.save(bomberos);
    }

    @PutMapping("/{id}")
    public Bomberos actualizarBomberos(@PathVariable Long id, @RequestBody Bomberos bomberos){
        bomberos.setId(id);
        return usuarioRepository.save(bomberos);
    }

    @DeleteMapping("/{id}")
    public void borrarBomberos(@PathVariable Long id ){
        usuarioRepository.deleteById(id);
    }
}
