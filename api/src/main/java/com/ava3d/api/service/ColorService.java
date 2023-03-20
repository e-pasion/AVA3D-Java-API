package com.ava3d.api.service;

import com.ava3d.api.entity.ColorEntity;
import com.ava3d.api.repository.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class ColorService {
    ColorRepository colorRepository;

    //Ver todos los colores
    public ResponseEntity< List<ColorEntity>> verTodos(){
        List<ColorEntity> result= colorRepository.findAll();
        return ResponseEntity.ok(result);
    }

    //Ver un solo color
    public ResponseEntity<ColorEntity> ver(Long id){
        Optional<ColorEntity> result= colorRepository.findById(id);
        return ResponseEntity.ok(result.get());
    }

    //guardar un color
    public ResponseEntity<ColorEntity> guardar(ColorEntity colorEntity){
        //el objeto que pasen no tiene que tener id
        if(colorEntity.getId()!=null){
            return ResponseEntity.badRequest().build();
        }
        ColorEntity result= colorRepository.save(colorEntity);
        return ResponseEntity.ok(result);
    }

    //Actualizar un color
    public ResponseEntity<ColorEntity> actualizar(ColorEntity colorEntity){
        //se tiene que pasar un id
        if(colorEntity.getId()==null){
            return ResponseEntity.badRequest().build();
        }
        //el id que se paso tiene que existir en la base de datos
        if(!colorRepository.existsById(colorEntity.getId())){
            return ResponseEntity.notFound().build();
        }
        ColorEntity result= colorRepository.save(colorEntity);
        return ResponseEntity.ok(result);
    }

    //borrar un color
    public ResponseEntity<ColorEntity> borrar(Long id){
        //el id que se paso tiene que existir en la base de datos
        if(!colorRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
