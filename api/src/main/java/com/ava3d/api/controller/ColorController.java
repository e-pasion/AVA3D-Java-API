package com.ava3d.api.controller;

import com.ava3d.api.entity.ColorEntity;
import com.ava3d.api.service.ColorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public class ColorController {
    ColorService colorService;

    //ver todos los colores
    @GetMapping("/api/color")
    public ResponseEntity<List<ColorEntity>> verColores(){
        return colorService.verTodos();
    }
    //ver un color
    @GetMapping("/api/color/{id}")

    public ResponseEntity<ColorEntity> verColor(@RequestParam Long id){
        return colorService.ver(id);
    }
    //crear un color
    @PostMapping("/api/color")
    public ResponseEntity<ColorEntity> guardarColor(@RequestBody ColorEntity colorEntity){
        return colorService.guardar(colorEntity);
    }
    //actualizar un color
    @PutMapping("/api/color")
    public ResponseEntity<ColorEntity> actualizarColor(@RequestBody ColorEntity colorEntity){
        return colorService.actualizar(colorEntity);
    }
    //borrar un color
    @DeleteMapping("/api/color/{id}")
    public ResponseEntity<ColorEntity> borrarColor(@RequestParam Long id){
        return colorService.borrar(id);
    }


}
