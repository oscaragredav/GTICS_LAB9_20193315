package com.example.lab9.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "participantespartido")
public class Participantespartido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idparticipantesPartido", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "partido_idpartido", nullable = false)
    private Partido partidoIdpartido;

    @ManyToOne
    @JoinColumn(name = "participante_idparticipante", nullable = false)
    private Participante participanteIdparticipante;

    @Column(name = "horaFecha", nullable = false)
    private Instant horaFecha;

}