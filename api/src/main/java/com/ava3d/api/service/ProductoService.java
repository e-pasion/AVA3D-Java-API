package com.ava3d.api.service;

import com.ava3d.api.entity.ProductoEntity;
import com.ava3d.api.repository.ProductoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class ProductoService {
    private CarritoService carritoService;
    private ProductoRepository productoRepository;
    private FileService fileService;


    //Ver todos los productos
    public ResponseEntity<List<ProductoEntity>> verTodos(){
        List<ProductoEntity> result= productoRepository.findAll();
        return ResponseEntity.ok(result);
    }

    //Ver un solo material
    public ResponseEntity<ProductoEntity> ver(Long id){
        Optional<ProductoEntity> result= productoRepository.findById(id);
        return ResponseEntity.ok(result.get());
    }

    //guardar un producto
    public ResponseEntity<ProductoEntity> guardar(MultipartFile img, MultipartFile stl, ProductoEntity productoEntity) {


        //el objeto que pasen no tiene que tener id
        if(productoEntity.getProductoId()!=null){
            return ResponseEntity.badRequest().build();
        }

        //se valida que el archivo que se haya pasado sea correcto
        if (img.isEmpty() ||stl.isEmpty()|| !fileService.validarStl(stl) || !fileService.validarImagen(img)) {
            return ResponseEntity.badRequest().build();
        }


        try {
            String urlArchivo= fileService.guardarArchivoCarrito(stl);
            productoEntity.setFilePath(urlArchivo);

            String urlImagen= fileService.guardarArchivoCarrito(img);
            productoEntity.setImagePath(urlImagen);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        productoEntity.setCarritoEntity(carritoService.ver(1L).getBody());

        ProductoEntity result= productoRepository.save(productoEntity);
        return ResponseEntity.ok(result);
    }

    //Actualizar un color
    public ResponseEntity<ProductoEntity> actualizar(ProductoEntity productoEntity){
        //se tiene que pasar un id
        if(productoEntity.getProductoId()==null){
            return ResponseEntity.badRequest().build();
        }
        //el id que se paso tiene que existir en la base de datos
        if(!productoRepository.existsById(productoEntity.getProductoId())){
            return ResponseEntity.notFound().build();
        }
        ProductoEntity result= productoRepository.save(productoEntity);
        return ResponseEntity.ok(result);
    }

    //borrar un color
    public ResponseEntity<ProductoEntity> borrar(Long id){
        //el id que se paso tiene que existir en la base de datos
        if(!productoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        productoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
