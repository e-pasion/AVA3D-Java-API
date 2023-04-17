package com.ava3d.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long idUsuario;
    private String email;
    private String nombre;
    private String password;

    @OneToOne(mappedBy = "usuarioEntity", cascade = CascadeType.ALL)
    private CarritoEntity carritoEntity;

    public UsuarioEntity(Long idUsuario, String email, String nombre, String password) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.carritoEntity = new CarritoEntity();
        this.carritoEntity.setUsuarioEntity(this);
    }
}
