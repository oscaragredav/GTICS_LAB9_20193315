package com.example.lab9.controller;


import com.example.lab9.entity.Historialpartidos;
import com.example.lab9.entity.Partido;
import com.example.lab9.repository.HistorialpartidosRepository;
import com.example.lab9.repository.PartidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/partido")
public class PartidoController {

    final PartidoRepository partidoRepository;
    final HistorialpartidosRepository historialPartidoRepository;

    public PartidoController(PartidoRepository partidoRepository, HistorialpartidosRepository historialPartidoRepository) {
        this.partidoRepository = partidoRepository;

        this.historialPartidoRepository = historialPartidoRepository;
    }


    @GetMapping(value = {"/", ""})
    public List<Partido> lista() {
        return partidoRepository.findAll();
    }

    //crear
    @PostMapping({"/registro","/registro/"})
    public ResponseEntity<HashMap<String, Object>> guardarPartido(
            @RequestBody Partido partido,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();

        partidoRepository.save(partido);
        if (fetchId) {
            responseJson.put("id", partido.getId());
        }
        responseJson.put("estado", "creado");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseJson);
    }



    // Listado de historial de productos
    @GetMapping(value = {"/gethistorialpartidos"})
    public List<Historialpartidos> listaPartidos() {
        return historialPartidoRepository.findAll();
    }

//    @GetMapping(value = {"/getparticipantes"})
//    public List<Object[]> listaParticipantes() {
//        return historialPartidoRepository.participantesXPartido();
//    }




}