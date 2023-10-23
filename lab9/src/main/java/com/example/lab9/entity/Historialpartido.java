package com.example.lab9.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "historialpartidos")
public class Historialpartido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhistorialPartidos", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "partido_idpartido", nullable = false)
    private Partido partidoIdpartido;

    @ManyToOne
    @JoinColumn(name = "deporte_iddeporte", nullable = false)
    private Deporte deporteIddeporte;

    @Column(name = "horaFecha", nullable = false)
    private Instant horaFecha;

}