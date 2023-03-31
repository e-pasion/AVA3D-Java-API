package com.ava3d.api.controller;

import com.ava3d.api.entity.MaterialEntity;
import com.ava3d.api.service.MaterialService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/material")
public class MaterialController {
    private MaterialService materialService;
    @GetMapping
    public ResponseEntity<List<MaterialEntity>> verMateriales(){
        return materialService.verTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<MaterialEntity> verMaterial(@PathVariable Long id){
        return materialService.ver(id);
    }
    @PostMapping
    public ResponseEntity<MaterialEntity> guardarMaterial(@RequestBody MaterialEntity materialEntity){
        return materialService.guardar(materialEntity);
    }
    @PutMapping
    public ResponseEntity<MaterialEntity> actualizarMaterial(@RequestBody MaterialEntity materialEntity){
        return materialService.actualizar(materialEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MaterialEntity> borrarMaterial(@PathVariable Long id){
        return materialService.borrar(id);
    }



}
