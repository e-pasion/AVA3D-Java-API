package com.ava3d.api.service;

import com.ava3d.api.entity.CarritoEntity;
import com.ava3d.api.entity.ColorEntity;
import com.ava3d.api.entity.UsuarioEntity;
import com.ava3d.api.repository.CarritoRepository;
import com.ava3d.api.repository.UsuarioRepository;
import com.ava3d.api.security.TokenUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CarritoService {
    private CarritoRepository carritoRepository;
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<CarritoEntity> ver(String token){
        String token2=token.replace("Bearer ","");
        UsuarioEntity usuarioEntity= usuarioRepository.findOneByEmail(TokenUtils.getUserEmail(token2)).get();
        CarritoEntity carritoEntity= usuarioEntity.getCarritoEntity();
       // Optional<CarritoEntity> carritoEntity= carritoRepository.findById(id);
        return ResponseEntity.ok(carritoEntity);

    }
    public CarritoEntity generarCarrito(){
        CarritoEntity carritoEntity= new CarritoEntity();
        CarritoEntity carritoGuardado= carritoRepository.save(carritoEntity);
        return carritoGuardado;
    }}
