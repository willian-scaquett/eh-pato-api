package com.patos.alens.demo.controller;

import com.patos.alens.demo.dto.NaveDTO;
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
    public ResponseEntity<?> criaNave(@RequestBody NaveDTO naveDTO) {
        return this.naveService.criaNave(naveDTO);
    }
}
