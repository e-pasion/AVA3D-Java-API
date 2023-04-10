package com.ava3d.api.repository;

import com.ava3d.api.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<ColorEntity,Long> {

}
