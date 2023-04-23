package com.ava3d.api.controller;

import com.ava3d.api.entity.CodigoEntity;
import com.ava3d.api.service.CodigoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/codigo")
public class CodigoController {
    private CodigoService codigoService;

    @PostMapping
    public ResponseEntity<CodigoEntity> crearCodigo(@RequestBody CodigoEntity codigoEntity){
        return codigoService.crear(codigoEntity);
    }
    @PostMapping("/verificar")
    public ResponseEntity<Float> verificarCodigo(@RequestHeader("Authorization") String token, @RequestBody CodigoEntity codigoEntity){
        return codigoService.verificar(codigoEntity,token);
    }
    @PutMapping("/add")
    public  ResponseEntity<String> addUsuario(@RequestHeader("Authorization") String token, @RequestBody CodigoEntity codigoEntity){
        return codigoService.add(codigoEntity,token);
    }


}
