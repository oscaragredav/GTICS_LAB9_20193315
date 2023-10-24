package com.example.lab9.controller;

import com.example.lab9.entity.Equipo;
import com.example.lab9.entity.Participante;
import com.example.lab9.repository.ParticipanteRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/participante")
public class ParticipantesController {

    final ParticipanteRepository participanteRepository;

    public ParticipantesController(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    //listar
    @GetMapping(value = {"/", ""})
    public List<Participante> lista() {
        return participanteRepository.findAll();
    }

    //crear
    @PostMapping({"/registro","/registro/"})
    public ResponseEntity<HashMap<String, Object>> guardarPart(
            @RequestBody Participante participante,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();

        participanteRepository.save(participante);
        if (fetchId) {
            responseJson.put("id", participante.getId());
        }
        responseJson.put("estado", "creado");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseJson);
    }




    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, String>> gestionException(HttpServletRequest request) {
        HashMap<String, String> responseMap = new HashMap<>();
        if (request.getMethod().equals("POST") || request.getMethod().equals("PUT")) {
            responseMap.put("estado", "error");
            responseMap.put("msg", "Debe enviar el contenido correctamente");
        }
        return ResponseEntity.badRequest().body(responseMap);
    }

}
