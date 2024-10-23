package com.patos.alens.demo.controller;

import com.patos.alens.demo.dto.NaveRequestDTO;
import com.patos.alens.demo.service.NaveService;
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
public class NaveController {

    private final NaveService naveService;

    public NaveController(NaveService naveService) {
        this.naveService = naveService;
    }

    /**
     * Lista todas as naves cadastradas.
     *
     * @return the response entity
     */
    @GetMapping("/listarTodas")
    public ResponseEntity<?> listarTodas() {
        return ResponseEntity.ok(naveService.listaNaves());
    }

    /**
     * Cria nave response entity.
     *
     * @param naveResponseDTO the nave response dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<?> criaNave(@RequestBody NaveRequestDTO naveResponseDTO) {
        return this.naveService.criaNave(naveResponseDTO);
    }

    /**
     * Busca nave pelo id response entity.
     *
     * @param idNave the id nave
     * @return the response entity
     */
    @GetMapping("/{idNave}")
    public ResponseEntity<?> buscaNavePeloId(@PathVariable Long idNave) {
        return this.naveService.buscaNavePeloId(idNave);
    }

    /**
     * Apaga nave response entity.
     *
     * @param idNave the id nave
     * @return the response entity
     */
    @DeleteMapping("/{idNave}")
    public ResponseEntity<?> apagaNave(@PathVariable Long idNave) {
        return this.naveService.apagaNave(idNave);
    }

    /**
     * Atualiza nave response entity.
     *
     * @param idNave          the id nave
     * @param naveResponseDTO the nave response dto
     * @return the response entity
     */
    @PutMapping("/{idNave}")
    public ResponseEntity<?> atualizaNave(@PathVariable Long idNave, @RequestBody NaveRequestDTO naveResponseDTO) {
        return this.naveService.atualizaNave(idNave, naveResponseDTO);
    }

    @GetMapping("/valoresSelectsCadastro")
    public ResponseEntity<?> getValoresSelectsCadastro() {
        return ResponseEntity.ok(naveService.getValoresSelectsCadastro());
    }
}
