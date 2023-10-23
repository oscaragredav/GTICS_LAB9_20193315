package com.example.lab9.controller;


import com.example.lab9.entity.Historialpartido;
import com.example.lab9.entity.Partido;
import com.example.lab9.repository.HistorialpartidoRepository;
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
    final HistorialpartidoRepository historialPartidoRepository;

    public PartidoController(PartidoRepository partidoRepository, HistorialpartidoRepository historialPartidoRepository) {
        this.partidoRepository = partidoRepository;

        this.historialPartidoRepository = historialPartidoRepository;
    }

    @PostMapping(value = {"/registro"})
    public ResponseEntity<HashMap<String, Object>> guardarDeporte(
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
    public List<Historialpartido> listaPartidos() {
        return historialPartidoRepository.findAll();
    }




}
