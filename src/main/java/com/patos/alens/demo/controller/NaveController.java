package com.patos.alens.demo.controller;

import com.patos.alens.demo.dto.NaveRequestDTO;
import com.patos.alens.demo.dto.NaveResponseDTO;
import com.patos.alens.demo.service.NaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("nave")
public class NaveController {

    @Autowired
    private NaveService naveService;

    @GetMapping
    public ResponseEntity<?> listaNaves() {
        return this.naveService.listaNaves();
    }
    @PostMapping
    public ResponseEntity<?> criaNave(@RequestBody NaveRequestDTO naveResponseDTO) {
        return this.naveService.criaNave(naveResponseDTO);
    }
    @GetMapping(value = "/{idNave}")
    public ResponseEntity<?> buscaNavePeloId(@PathVariable Long idNave) {
        return this.naveService.buscaNavePeloId(idNave);
    }

    @DeleteMapping(value = "/{idNave}")
    public ResponseEntity<?> apagaNave(@PathVariable Long idNave) {
        return this.naveService.apagaNave(idNave);
    }
    @PutMapping(value = "/{idNave}")
    public ResponseEntity<?> atualizaNave(@PathVariable Long idNave, @RequestBody NaveRequestDTO naveResponseDTO) {
        return this.naveService.atualizaNave(idNave, naveResponseDTO);
    }
}
