package com.patos.alens.demo.controller;

import com.patos.alens.demo.dto.EhPatoRequestDTO;
import com.patos.alens.demo.service.EhPatoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("ehPato")
@Tag(name = "Pato controller")
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
