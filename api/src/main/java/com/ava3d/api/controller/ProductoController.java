package com.ava3d.api.controller;

import com.ava3d.api.entity.MaterialEntity;
import com.ava3d.api.entity.ProductoEntity;
import com.ava3d.api.service.ProductoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductoController {

    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoEntity>> verProductos(){
        return productoService.verTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductoEntity> verProducto(@PathVariable Long id){
        return productoService.ver(id);
    }
    @PostMapping
    public ResponseEntity<ProductoEntity> guardarProducto(@RequestParam("img") MultipartFile img,@RequestParam("archivo") MultipartFile archivo, @RequestParam("json") String json ) {

        // Convertir el JSON a un objeto ProductoEntity
        ObjectMapper mapper = new ObjectMapper();
        ProductoEntity productoEntity = null;
        try {
            productoEntity = mapper.readValue(json, ProductoEntity.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

        return productoService.guardar(img,archivo,productoEntity);
    }

    @PutMapping
    public ResponseEntity<ProductoEntity> actualizarProducto(@RequestBody ProductoEntity productoEntity){
        return productoService.actualizar(productoEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoEntity> borrarProducto(@PathVariable Long id){
        return productoService.borrar(id);
    }



}
