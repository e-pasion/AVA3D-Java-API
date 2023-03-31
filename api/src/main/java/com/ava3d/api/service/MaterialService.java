package com.ava3d.api.service;

import com.ava3d.api.entity.MaterialEntity;
import com.ava3d.api.repository.MaterialRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class MaterialService {
    private MaterialRepository materialRepository;


    //Ver todos los materiales
    public ResponseEntity<List<MaterialEntity>> verTodos(){
        List<MaterialEntity> result= materialRepository.findAll();
        return ResponseEntity.ok(result);
    }

    //Ver un solo material
    public ResponseEntity<MaterialEntity> ver(Long id){
        Optional<MaterialEntity> result= materialRepository.findById(id);
        return ResponseEntity.ok(result.get());
    }

    //guardar un color
    public ResponseEntity<MaterialEntity> guardar(MaterialEntity materialEntity){
        //el objeto que pasen no tiene que tener id
        if(materialEntity.getMaterialId()!=null){
            return ResponseEntity.badRequest().build();
        }
        MaterialEntity result= materialRepository.save(materialEntity);
        return ResponseEntity.ok(result);
    }

    //Actualizar un color
    public ResponseEntity<MaterialEntity> actualizar(MaterialEntity materialEntity){
        //se tiene que pasar un id
        if(materialEntity.getMaterialId()==null){
            return ResponseEntity.badRequest().build();
        }
        //el id que se paso tiene que existir en la base de datos
        if(!materialRepository.existsById(materialEntity.getMaterialId())){
            return ResponseEntity.notFound().build();
        }
        MaterialEntity result= materialRepository.save(materialEntity);
        return ResponseEntity.ok(result);
    }

    //borrar un color
    public ResponseEntity<MaterialEntity> borrar(Long id){
        //el id que se paso tiene que existir en la base de datos
        if(!materialRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        materialRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
