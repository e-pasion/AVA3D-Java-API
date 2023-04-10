package com.ava3d.api.repository;

import com.ava3d.api.entity.MaterialColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialColorRepository extends JpaRepository<MaterialColorEntity,Long> {

}
