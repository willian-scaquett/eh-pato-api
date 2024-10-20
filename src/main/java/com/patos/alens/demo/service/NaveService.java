package com.patos.alens.demo.service;

import com.patos.alens.demo.dto.NaveDTO;
import com.patos.alens.demo.entity.NaveEntity;
import com.patos.alens.demo.entity.TripulanteEntity;
import com.patos.alens.demo.repository.NaveRepository;
import com.patos.alens.demo.repository.TripulanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NaveService {

    @Autowired
    NaveRepository naveRepository;
    @Autowired
    TripulanteRepository tripulanteRepository;

    public ResponseEntity<?> listaNaves() {
        return ResponseEntity.of(Optional.of(naveRepository.findAll()));
    }

    public ResponseEntity<?> criaNave(NaveDTO naveDTO) {

        NaveEntity naveEntity = new NaveEntity();
        naveEntity.setPotencialTecnologico(naveDTO.getPotencialTecnologico());
        naveEntity.setArmamentoNave(naveDTO.getArmamentoNave());
        naveEntity.setCorNave(naveDTO.getCorNave());
        naveEntity.setTipoCombustivel(naveDTO.getTipoCombustivel());
        naveEntity.setGrauAvaria(naveDTO.getGrauAvaria());
        naveEntity.setLocalQuedaNave(naveDTO.getLocalQuedaNave());
        naveEntity.setNomeNave(naveDTO.getNomeNave());

        List<TripulanteEntity> tripulanteEntityList = naveDTO.getListaDeTripulantes().stream()
                .map(id -> this.tripulanteRepository.findById(id).orElse(null))
                .toList();
        naveEntity.setListaDeTripulantes(tripulanteEntityList);
        naveRepository.save(naveEntity);

        return ResponseEntity.ok(naveDTO);

    }
}
