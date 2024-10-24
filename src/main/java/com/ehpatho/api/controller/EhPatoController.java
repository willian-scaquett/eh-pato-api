package com.ehpatho.api.controller;

import com.ehpatho.api.dto.EhPatoRequestDTO;
import com.ehpatho.api.service.EhPatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * A classe EhPatoController é responsável por realizar o intermédio entre a API da IA, que identifica o elemento
 * suspeito como pato ou alien, e o front-end, além de retornar as armas e abordagens dos agentes.
 *
 * @author Willian Scaquett willian.scaquett@gmail.com
 */
@RestController
@RequestMapping("ehPato")
@CrossOrigin
@Tag(name = "EhPato controller")
public class EhPatoController {

    private final EhPatoService ehPatoService;

    public EhPatoController(EhPatoService ehPatoService) {
        this.ehPatoService = ehPatoService;
    }

    @Operation(summary = "Endpoint responsável por identificar se elemento suspeito é pato ou alien e elaborar uma estratégia para combatê-lo" +
            " quando for o caso")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Classificação e escolha de armas e abordagens feitas com sucesso"),
            @ApiResponse(responseCode = "500", description = "Falha de comunicação com a API da IA")
    })
    @PostMapping(value = "/identificarECriarEstrategia")
    public ResponseEntity<?> identificarECriarEstrategia(@RequestBody EhPatoRequestDTO ehPatoRequestDTO) {
        return ResponseEntity.ok(ehPatoService.criarEstrategia(ehPatoRequestDTO));
    }
}
