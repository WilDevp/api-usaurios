package com.fullstackmasters.controllers;

import com.fullstackmasters.models.Usuario;
import com.fullstackmasters.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
     private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuario(){
        List<Usuario> usuario = usuarioRepository.findAll();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        Usuario Crearusuario = usuarioRepository.save(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }
}
