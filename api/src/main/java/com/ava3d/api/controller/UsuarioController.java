package com.ava3d.api.controller;

import com.ava3d.api.entity.UsuarioEntity;
import com.ava3d.api.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/registro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<UsuarioEntity> registro(@RequestBody UsuarioEntity usuarioEntity){
        return usuarioService.registro(usuarioEntity);
    }
}
