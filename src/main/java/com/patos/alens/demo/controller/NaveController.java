package com.patos.alens.demo.controller;

import com.patos.alens.demo.service.NaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Nave")
public class NaveController {

    @Autowired
    private NaveService naveService;

//    @GetMapping
  //  public ResponseEntity<?> findAllShip() {
  //      return this.naveService.findAllShip();
   // }

}
