package com.ava3d.api.service;

import com.ava3d.api.entity.CarritoEntity;
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
    private CarritoService carritoService;


    public ResponseEntity<UsuarioEntity> registro(UsuarioEntity usuarioEntity){
        CarritoEntity carrito=carritoService.generarCarrito();//crea un carrito
        usuarioEntity.setPassword(new BCryptPasswordEncoder().encode(usuarioEntity.getPassword()));
        usuarioEntity.setCarritoEntity(carrito);
        UsuarioEntity result= usuarioRepository.save(usuarioEntity);
        return ResponseEntity.ok(result);
    }
}
