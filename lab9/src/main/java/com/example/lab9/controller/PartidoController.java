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
import java.util.Optional;

@RestController
@RequestMapping("/partido")
public class PartidoController {

    final PartidoRepository partidoRepository;
    final HistorialpartidoRepository historialPartidoRepository;

    public PartidoController(PartidoRepository partidoRepository, HistorialpartidoRepository historialPartidoRepository) {
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


    // EJERCICIO 2C
    @GetMapping(value = "/gethistorialpartidos")
    public ResponseEntity<?> buscarPartido(@RequestParam(name = "idequipo", required = false) String idequipo) {
        if (idequipo != null) {
            HashMap<String, Object> respuesta2 = new HashMap<>();
            try {
                int id = Integer.parseInt(idequipo);
                Optional<Partido> byId = partidoRepository.findById(id);

                HashMap<String, Object> respuesta = new HashMap<>();

                if (byId.isPresent()) {
                    respuesta.put("result", "ok");
                    respuesta.put("producto", byId.get());
                } else {
                    respuesta.put("result", "no existe");
                }
                return ResponseEntity.ok(respuesta);
            } catch (NumberFormatException e) {
                respuesta2.put("result", "error");
                respuesta2.put("msg", "El ID ingresado es incorrecta");
                return ResponseEntity.badRequest().body(respuesta2);
            }
        } else {
            List<Historialpartido> historialPartidos = listaPartidos();
            return ResponseEntity.ok(historialPartidos);
        }
    }

    @GetMapping(value = {"/gethistorialpartidosSegundo"})
    public List<Historialpartido> listaPartidos() {
        return historialPartidoRepository.findAll();
    }



}