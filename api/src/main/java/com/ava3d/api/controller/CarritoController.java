package com.ava3d.api.controller;

import com.ava3d.api.entity.CarritoEntity;
import com.ava3d.api.service.CarritoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/carrito")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarritoController {
    private CarritoService carritoService;


    @GetMapping
    public ResponseEntity<CarritoEntity> verCarrito(@RequestHeader("Authorization") String token){
        return carritoService.ver(token);
    }
}
