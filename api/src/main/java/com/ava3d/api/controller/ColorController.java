package com.ava3d.api.controller;

import com.ava3d.api.entity.ColorEntity;
import com.ava3d.api.service.ColorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/color")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ColorController {
    ColorService colorService;

    //ver todos los colores
    @GetMapping
    public ResponseEntity<List<ColorEntity>> verColores(){
        return colorService.verTodos();
    }
    //ver un color
    @GetMapping("/{id}")
    public ResponseEntity<ColorEntity> verColor(@PathVariable Long id){
        return colorService.ver(id);
    }
    //crear un color
    @PostMapping
    public ResponseEntity<ColorEntity> guardarColor(@RequestBody ColorEntity colorEntity){
        return colorService.guardar(colorEntity);
    }
    //actualizar un color
    @PutMapping
    public ResponseEntity<ColorEntity> actualizarColor(@RequestBody ColorEntity colorEntity){
        return colorService.actualizar(colorEntity);
    }
    //borrar un color
    @DeleteMapping("/{id}")
    public ResponseEntity<ColorEntity> borrarColor(@PathVariable Long id){
        return colorService.borrar(id);
    }


}
