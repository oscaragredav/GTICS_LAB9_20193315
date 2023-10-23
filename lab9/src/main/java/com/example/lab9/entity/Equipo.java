package com.example.lab9.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "equipo")
public class Equipo {
    @Id
    @Column(name = "idequipo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombreEquipo", nullable = false, length = 45)
    private String nombreEquipo;

    @Column(name = "colorEquipo", nullable = false, length = 45)
    private String colorEquipo;

    @Column(name = "mascota", nullable = false, length = 45)
    private String mascota;

}