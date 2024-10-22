package com.patos.alens.demo.controller;

import com.patos.alens.demo.dto.EhPatoRequestDTO;
import com.patos.alens.demo.service.EhPatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("ehPato")
public class EhPatoController {

    private final EhPatoService ehPatoService;

    public EhPatoController(EhPatoService ehPatoService) {
        this.ehPatoService = ehPatoService;
    }

    @PostMapping(value = "/identificarECriarEstrategia")
    public ResponseEntity<?> identificarECriarEstrategia(@RequestBody EhPatoRequestDTO ehPatoRequestDTO) {
        return ResponseEntity.ok(ehPatoService.criarEstrategia(ehPatoRequestDTO));
    }
}
