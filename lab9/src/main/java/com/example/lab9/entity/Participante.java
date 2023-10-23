package com.example.lab9.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "participante")
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idparticipante", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "equipo", nullable = false)
    private Equipo equipo;

    @Column(name = "carrera", nullable = false, length = 45)
    private String carrera;

    @Column(name = "codigo", nullable = false, precision = 10)
    private BigDecimal codigo;

    @Column(name = "tipoParticipante", nullable = false, length = 45)
    private String tipoParticipante;

}