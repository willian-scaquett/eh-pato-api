package com.patos.alens.demo.controller;

import com.patos.alens.demo.dto.EhPatoRequestDTO;
import com.patos.alens.demo.service.EhPatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Endpoint responsável por identificar se elemento suspeito é alien e elaborar uma estratégia para combatê-lo")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Classificação do elemento suspeito e arma e abordagem recomendadas"),
            @ApiResponse(responseCode = "500", description = "Falha de comunicação com a API Python da IA")
    })
    @PostMapping(value = "/identificarECriarEstrategia")
    public ResponseEntity<?> identificarECriarEstrategia(@RequestBody EhPatoRequestDTO ehPatoRequestDTO) {
        return ResponseEntity.ok(ehPatoService.criarEstrategia(ehPatoRequestDTO));
    }
}
