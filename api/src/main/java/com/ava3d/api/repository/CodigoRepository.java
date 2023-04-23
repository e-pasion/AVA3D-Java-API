package com.ava3d.api.repository;

import com.ava3d.api.entity.CodigoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodigoRepository extends JpaRepository<CodigoEntity,Long> {
    Optional<CodigoEntity> findOneByCodigo(String codigo);
    boolean existsByCodigo(String codigo);
}
