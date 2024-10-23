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

    /**
     * Lista todas as naves cadastradas.
     *
     * @return todas as naves cadastradas
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de todas as naves")
    })
    @GetMapping("/listarTodas")
    public ResponseEntity<?> listarTodas() {
        return ResponseEntity.ok(naveService.listaNaves());
    }

    /**
     * Cria uma nova nave.
     *
     * @param naveResponseDTO nave que será criada.
     * @return nave criada
     */
    @PostMapping
    @Operation(summary = "Endpoint responsável por cadastrar uma nova nave")
    @ApiResponses({
            @ApiResponse(responseCode = "404", description = "Nave não encontrada"),
            @ApiResponse(responseCode = "200", description = "Nave criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Nome de nave duplicado")
    })
    public ResponseEntity<?> criaNave(@RequestBody NaveRequestDTO naveResponseDTO) throws BadRequestException {
        return ResponseEntity.ok(this.naveService.criaNave(naveResponseDTO));
    }

    /**
     * Busca nave pelo identificador
     *
     * @param idNave identificador da nave
     * @return nave encontrada
     */
    @GetMapping("/{idNave}")
    @Operation(summary = "Endpoint responsável por buscar uma nave atráves do identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "404", description = "Nave não encontrada"),
            @ApiResponse(responseCode = "200", description = "Nave encontrada com sucesso")
    })
    public ResponseEntity<?> buscaNavePeloId(@PathVariable Long idNave) {
        return this.naveService.buscaNavePeloId(idNave);
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
