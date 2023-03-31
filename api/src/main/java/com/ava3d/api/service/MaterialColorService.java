package com.ava3d.api.service;

import com.ava3d.api.entity.ColorEntity;
import com.ava3d.api.entity.MaterialColorEntity;
import com.ava3d.api.entity.MaterialEntity;
import com.ava3d.api.repository.ColorRepository;
import com.ava3d.api.repository.MaterialColorRepository;
import com.ava3d.api.repository.MaterialRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class MaterialColorService {
    private MaterialColorRepository materialColorRepository;
    private MaterialRepository materialRepository;
    private ColorRepository colorRepository;


    public ResponseEntity<List<MaterialColorEntity>> verTodos(){
        List<MaterialColorEntity> result = materialColorRepository.findAll();
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<MaterialColorEntity> ver(Long id){
        Optional<MaterialColorEntity> result= materialColorRepository.findById(id);
        return ResponseEntity.ok(result.get());
    }

    public ResponseEntity<MaterialColorEntity> guardar(MaterialColorEntity materialColorEntity){
        //el objeto que pasen no tiene que tener id
        if(materialColorEntity.getMaterialColorId()!=null){
            return ResponseEntity.badRequest().build();
        }
        MaterialColorEntity result= materialColorRepository.save(materialColorEntity);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<MaterialColorEntity> actualizar(MaterialColorEntity materialColorEntity){
        //se tiene que pasar un id
        if(materialColorEntity.getMaterialColorId()==null){
            return ResponseEntity.badRequest().build();
        }
        //el id que se paso tiene que existir en la base de datos
        if(!materialColorRepository.existsById(materialColorEntity.getMaterialColorId())){
            return ResponseEntity.notFound().build();
        }
        MaterialColorEntity result= materialColorRepository.save(materialColorEntity);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<MaterialColorEntity> borrar(Long id){
        //el id que se paso tiene que existir en la base de datos
        if(!materialColorRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        materialColorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
