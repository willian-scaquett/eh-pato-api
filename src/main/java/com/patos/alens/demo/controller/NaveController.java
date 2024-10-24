package com.patos.alens.demo.controller;

import com.patos.alens.demo.dto.NaveRequestDTO;
import com.patos.alens.demo.dto.ResponseDTO;
import com.patos.alens.demo.service.NaveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * A classe NaveController é responsável por disponibilizar os endpoints para CRUD de nave
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

    @Operation(summary = "Endpoint responsável por apagar uma nave através do ID informado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Nave excluída com sucesso"),
            @ApiResponse(responseCode = "400", description = "Nave não encontrada")
    })
    @DeleteMapping("/apagar/{idNave}")
    public ResponseEntity<?> apagarNave(@PathVariable Long idNave) throws BadRequestException {
        naveService.apagarNave(idNave);
        return ResponseEntity.ok(new ResponseDTO("Sucesso"));
    }

    @Operation(summary = "Endpoint responsável por atualizar uma nave através do ID informado e dos dados passados no body.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Nave atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Nave não encontrada"),
    })
    @PutMapping("/editar/{idNave}")
    public ResponseEntity<?> editarNave(@PathVariable Long idNave, @RequestBody NaveRequestDTO naveResponseDTO) throws BadRequestException {
        return ResponseEntity.ok(naveService.editarNave(idNave, naveResponseDTO));
    }

    @Operation(summary = "Endpoint responsável por buscar uma nave através do identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Nave encontrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Nave não encontrada")
    })
    @GetMapping("/{idNave}")
    public ResponseEntity<?> buscaNavePeloId(@PathVariable Long idNave) throws BadRequestException {
        return ResponseEntity.ok(naveService.buscaNavePeloId(idNave));
    }

    @Operation(summary = "Endpoint responsável informar os valores dos selects da tela de cadastro e edição de nave.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Valores dos selects retornados com sucesso")
    })
    @GetMapping("/valoresSelectsCadastro")
    public ResponseEntity<?> getValoresSelectsCadastro() {
        return ResponseEntity.ok(naveService.getValoresSelectsCadastro());
    }
}
