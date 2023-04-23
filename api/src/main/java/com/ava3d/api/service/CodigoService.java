package com.ava3d.api.service;

import com.ava3d.api.entity.CodigoEntity;
import com.ava3d.api.entity.UsuarioEntity;
import com.ava3d.api.repository.CodigoRepository;
import com.ava3d.api.repository.UsuarioRepository;
import com.ava3d.api.security.TokenUtils;
import lombok.AllArgsConstructor;
import org.springframework.expression.spel.CodeFlow;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CodigoService {
    private CodigoRepository codigoRepository;
    private UsuarioRepository usuarioRepository;
    public ResponseEntity<CodigoEntity> crear(CodigoEntity codigoEntity){

        if(codigoEntity.getIdCodigo()!=null){
            return ResponseEntity.badRequest().build();
        }

        CodigoEntity result=codigoRepository.save(codigoEntity);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<Float> verificar(CodigoEntity codigoEntity,String token){
        if(!codigoRepository.existsByCodigo(codigoEntity.getCodigo())){
            return ResponseEntity.notFound().build();
        }
        CodigoEntity codigoResult= codigoRepository.findOneByCodigo(codigoEntity.getCodigo()).get();
        LocalDate fechaActual = LocalDate.now(ZoneId.of("America/Bogota"));
        System.out.println(fechaActual);
        if(!(fechaActual.isAfter(codigoResult.getFechaInicio())&& fechaActual.isBefore(codigoResult.getFechaFinal()))){
            return ResponseEntity.badRequest().build();
        }
        String token2=token.replace("Bearer ","");
        if(codigoResult.getUsuarios().contains(usuarioRepository.findOneByEmail(TokenUtils.getUserEmail(token2)))){
           return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(codigoResult.getDescuento());
    }

    public ResponseEntity<String> add(CodigoEntity codigoEntity,String token){
        if(codigoEntity.getIdCodigo()==null){
            return ResponseEntity.badRequest().build();
        }
        String token2=token.replace("Bearer ","");
        Optional<UsuarioEntity> usuarioEntity= usuarioRepository.findOneByEmail(TokenUtils.getUserEmail(token2));
        codigoEntity.getUsuarios().add(usuarioEntity.get());
        codigoRepository.save(codigoEntity);
        return ResponseEntity.ok("todo god");
    }

}
