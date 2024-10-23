package com.patos.alens.demo.controller;

import com.patos.alens.demo.dto.NaveRequestDTO;
import com.patos.alens.demo.service.NaveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * A classe NaveController é reponsável por disponibilizar os recursos disponiveis para CRUD de nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@RestController
@RequestMapping("nave")
@CrossOrigin
@Tag(name = "Nave controller")
public class NaveController {

    private final NaveService naveService;

    public NaveController(NaveService naveService) {
        this.naveService = naveService;
    }

    @Operation(summary = "Endpoint responsável por listar todas as naves")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de todas as naves")
    })
    @GetMapping("/listarTodas")
    public ResponseEntity<?> listarTodas() {
        return ResponseEntity.ok(naveService.listaNaves());
    }

    @Operation(summary = "Endpoint responsável por cadastrar uma nova nave, definir os atributos periculosidade " +
            "e classifcacao e retornar um DTO com esses campos já definidos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Nave criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Nome de nave duplicado")
    })
    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody NaveRequestDTO naveResponseDTO) throws BadRequestException {
        return ResponseEntity.ok(naveService.criarNave(naveResponseDTO));
    }

    /**
     * Apaga uma nave atráves do identificador.
     *
     * @param idNave identificador da nave
     * @return status code
     */
    @ApiResponses({
            @ApiResponse(responseCode = "404", description = "Nave não encontrada"),
            @ApiResponse(responseCode = "204", description = "Máquina excluída com sucesso")
    })
    @DeleteMapping("/{idNave}")
    public ResponseEntity<?> apagaNave(@PathVariable Long idNave) {
        return this.naveService.apagaNave(idNave);
    }

    /**
     * Atualiza uma nave atráves de um {@link NaveResponseDTO} e seu identificador.
     *
     * @param idNave          identificador da nave
     * @param naveResponseDTO atualização da nave
     * @return nave atualizada
     */
    @ApiResponses({
            @ApiResponse(responseCode = "404", description = "Nave não encontrada"),
            @ApiResponse(responseCode = "200", description = "Nave atualizada com sucesso")
    })
    @PutMapping("/{idNave}")
    public ResponseEntity<?> atualizaNave(@PathVariable Long idNave, @RequestBody NaveRequestDTO naveResponseDTO) throws BadRequestException {
        return this.naveService.atualizaNave(idNave, naveResponseDTO);
    }

    @GetMapping("/valoresSelectsCadastro")
    public ResponseEntity<?> getValoresSelectsCadastro() {
        return ResponseEntity.ok(naveService.getValoresSelectsCadastro());
    }
}
