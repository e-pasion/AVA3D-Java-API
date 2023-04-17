package com.ava3d.api.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Carrito")
public class CarritoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrito_id")
    private Long idCarrito;

    @JsonManagedReference
    @OneToMany(mappedBy = "carritoEntity")
    private List<ProductoEntity> productoEntities;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuarioEntity;
}
