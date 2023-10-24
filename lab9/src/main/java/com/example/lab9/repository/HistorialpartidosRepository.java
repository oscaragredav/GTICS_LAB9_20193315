package com.example.lab9.repository;

import com.example.lab9.entity.Historialpartidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistorialpartidosRepository extends JpaRepository<Historialpartidos,Integer> {

//    @Query("SELECT \n" +
//            "    hp.idhistorialPartidos,\n" +
//            "    p.idparticipante,\n" +
//            "    p.equipo,\n" +
//            "    p.carrera,\n" +
//            "    p.codigo,\n" +
//            "    p.tipoParticipante\n" +
//            "FROM \n" +
//            "    historialpartidos hp\n" +
//            "JOIN \n" +
//            "    participantespartido pp ON hp.idhistorialPartidos = pp.idparticipantesPartido\n" +
//            "JOIN \n" +
//            "    participante p ON pp.participante_idparticipante = p.idparticipante;")
//    List<Object[]> participantesXPartido();
}

