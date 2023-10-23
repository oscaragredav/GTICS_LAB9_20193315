package com.example.lab9.controller;

import com.example.lab9.entity.Participante;
import com.example.lab9.entity.Partido;
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

    public PartidoController(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
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

}
