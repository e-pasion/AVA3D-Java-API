package com.ava3d.api.service;

import com.ava3d.api.entity.UsuarioEntity;
import com.ava3d.api.repository.CarritoRepository;
import com.ava3d.api.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private CarritoRepository carritoRepository;
    private CarritoService carritoService;
    public ResponseEntity<UsuarioEntity> registro(UsuarioEntity usuarioEntity){
        usuarioEntity.setPassword(new BCryptPasswordEncoder().encode(usuarioEntity.getPassword()));
        UsuarioEntity result= usuarioRepository.save(usuarioEntity);
        carritoRepository.save(usuarioEntity.getCarritoEntity());
        return ResponseEntity.ok(result);
    }
}
