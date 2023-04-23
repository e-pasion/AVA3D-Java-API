package com.ava3d.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Codigo")
public class CodigoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_id")
    private Long idCodigo;
    private String codigo;
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    private Float descuento;
    @Column(name="fecha_final")
    private LocalDate fechaFinal;

    @ManyToMany
    @JoinTable(name="codigos_usados",joinColumns = @JoinColumn(name = "codigo_id"),inverseJoinColumns = @JoinColumn(name="usuario_id"))
    private Set<UsuarioEntity> Usuarios=new HashSet<>();

}
