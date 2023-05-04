package com.ava3d.api.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Producto")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "productoId")
public class ProductoEntity {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productoId;
    private String imagePath;
    private String filePath;
    private Float peso;
    private String estado;
    private Integer cantidad;

    private Float tamX;
    private Float tamY;
    private Float tamZ;
    @ManyToOne
    @JoinColumn(name = "material_color_id")
    private MaterialColorEntity materialColorEntity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "carrito_id")
    private CarritoEntity carritoEntity;





}
