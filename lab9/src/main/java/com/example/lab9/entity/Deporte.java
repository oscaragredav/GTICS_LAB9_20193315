package com.example.lab9.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "deporte")
public class Deporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddeporte", nullable = false)
    private Integer id;

    @Column(name = "nombreDeporte", nullable = false, length = 45)
    private String nombreDeporte;

    @Column(name = "pesoDeporte", nullable = false)
    private Integer pesoDeporte;

}