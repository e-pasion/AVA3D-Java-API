package com.ava3d.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Material_Color")
public class MaterialColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_color_id")
    private Long materialColorId;


    @ManyToOne
   // @MapsId("materialId")
    @JoinColumn(name = "material_id")
    private MaterialEntity materialEntity;

    @ManyToOne
    //@MapsId("colorId")
    @JoinColumn(name = "color_id")
    private ColorEntity colorEntity;

    //@JsonManagedReference
    //@OneToMany(mappedBy = "materialColorEntity")
    //private List<ProductoEntity> productoEntities;

}
