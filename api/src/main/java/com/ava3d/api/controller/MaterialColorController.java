package com.ava3d.api.controller;

import com.ava3d.api.entity.MaterialColorEntity;
import com.ava3d.api.service.MaterialColorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/material/color")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MaterialColorController {
    private MaterialColorService materialColorService;
    @GetMapping
    public ResponseEntity<List<MaterialColorEntity>> verMaterialesColores(){
        return materialColorService.verTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<MaterialColorEntity> verMaterialColor(@PathVariable Long id){
        return materialColorService.ver(id);
    }
    @PostMapping
    public ResponseEntity<MaterialColorEntity> guardarMaterialColor(@RequestBody MaterialColorEntity materialColorEntity){
        return materialColorService.guardar(materialColorEntity);
    }
    @PutMapping
    public ResponseEntity<MaterialColorEntity> actualizarMaterialColor(@RequestBody MaterialColorEntity materialColorEntity){
        return materialColorService.actualizar(materialColorEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MaterialColorEntity> borrarMaterialColor(@PathVariable Long id){
        return materialColorService.borrar(id);
    }



}
