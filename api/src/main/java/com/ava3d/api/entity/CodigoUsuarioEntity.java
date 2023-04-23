//package com.ava3d.api.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//@Table(name = "codigos_usados")
//public class CodigoUsuarioEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="codigo_usuario_id")
//    private Long codigoUsuarioId;
//
//    @ManyToOne
//    @JoinColumn(name="codigo_id")
//    private CodigoEntity codigoEntity;
//    @ManyToOne
//    @JoinColumn(name = "usuario_id")
//    private UsuarioEntity usuarioEntity;
//}
