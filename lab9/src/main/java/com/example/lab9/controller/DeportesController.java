package com.example.lab9.controller;

import com.example.lab9.entity.Deporte;
import com.example.lab9.entity.Equipo;
import com.example.lab9.repository.DeporteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/deporte")
public class DeportesController {

    final DeporteRepository deporteRepository;

    public DeportesController(DeporteRepository deporteRepository) {
        this.deporteRepository = deporteRepository;
    }

    @GetMapping(value = {"/", ""})
    public List<Deporte> lista() {
        return deporteRepository.findAll();
    }

    //crear
    @PostMapping({"/registro","/registro/"})
    public ResponseEntity<HashMap<String, Object>> guardarDep(
            @RequestBody Deporte deporte,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();

        deporteRepository.save(deporte);
        if (fetchId) {
            responseJson.put("id", deporte.getId());
        }
        responseJson.put("estado", "creado");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseJson);
    }
}
