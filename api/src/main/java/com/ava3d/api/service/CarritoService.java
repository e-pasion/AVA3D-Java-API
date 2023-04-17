package com.ava3d.api.service;

import com.ava3d.api.entity.CarritoEntity;
import com.ava3d.api.entity.ColorEntity;
import com.ava3d.api.entity.UsuarioEntity;
import com.ava3d.api.repository.CarritoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CarritoService {
    private CarritoRepository carritoRepository;

    public ResponseEntity<CarritoEntity> ver(Long id){
        Optional<CarritoEntity> carritoEntity= carritoRepository.findById(id);
        return ResponseEntity.ok(carritoEntity.get());

    }
    public CarritoEntity generarCarrito(CarritoEntity carritoEntity){
        return carritoRepository.save(carritoEntity);
    }}
