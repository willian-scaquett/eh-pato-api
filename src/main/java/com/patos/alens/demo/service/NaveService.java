package com.patos.alens.demo.service;

import com.patos.alens.demo.dto.NaveRequestDTO;
import com.patos.alens.demo.dto.NaveResponseDTO;
import com.patos.alens.demo.entity.NaveEntity;
import com.patos.alens.demo.entity.TripulanteEntity;
import com.patos.alens.demo.repository.NaveRepository;
import com.patos.alens.demo.repository.TripulanteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NaveService {

    @Autowired
    NaveRepository naveRepository;
    @Autowired
    TripulanteRepository tripulanteRepository;

    public ResponseEntity<?> listaNaves() {
        return ResponseEntity.of(Optional.of(naveRepository.findAll()));
    }

    public ResponseEntity<?> criaNave(NaveRequestDTO naveRequestDTO) {

        NaveEntity naveEntity = new NaveEntity();
        naveEntity.setPotencialTecnologico(naveRequestDTO.getPotencialTecnologico());
        naveEntity.setArmamentoNave(naveRequestDTO.getArmamentoNave());
        naveEntity.setCorNave(naveRequestDTO.getCorNave());
        naveEntity.setTipoCombustivel(naveRequestDTO.getTipoCombustivel());
        naveEntity.setGrauAvaria(naveRequestDTO.getGrauAvaria());
        naveEntity.setLocalQuedaNave(naveRequestDTO.getLocalQuedaNave());
        naveEntity.setNomeNave(naveRequestDTO.getNomeNave());

        List<TripulanteEntity> tripulanteEntityList = naveRequestDTO.getListaDeTripulantes()
            .stream()
                .map(id -> this.tripulanteRepository.findById(id).orElse(null))
                .toList();
        naveEntity.setListaDeTripulantes(tripulanteEntityList);
        naveRepository.save(naveEntity);

        return ResponseEntity.ok(naveEntity);

    }

    public ResponseEntity<?> buscaNavePeloId(Long id) {
        NaveEntity naveEntity = this.naveRepository.findById(id).orElse(null);

        if (naveEntity == null) {
            return ResponseEntity.notFound().build();
        }
        List<TripulanteEntity> tripulanteEntityList = naveEntity.getListaDeTripulantes();

        Long totalTripulantesMortos = tripulanteEntityList.stream()
            .filter(tripulante -> !tripulante.estaVivo()).count();

        NaveResponseDTO naveResponseDTO = new NaveResponseDTO();
        naveResponseDTO.setNomeNave(naveEntity.getNomeNave());
        naveResponseDTO.setCorNave(naveEntity.getCorNave());
        naveResponseDTO.setLocalQuedaNave(naveEntity.getLocalQuedaNave());
        naveResponseDTO.setArmamentoNave(naveEntity.getArmamentoNave());
        naveResponseDTO.setTipoCombustivel(naveEntity.getTipoCombustivel());
        naveResponseDTO.setListaDeTripulantes(naveEntity.getListaDeTripulantes());
        naveResponseDTO.setGrauAvaria(naveEntity.getGrauAvaria());
        naveResponseDTO.setPotencialTecnologico(naveEntity.getPotencialTecnologico());
        naveResponseDTO.setTotalTripulantes((long) naveEntity.getListaDeTripulantes().size());
        naveResponseDTO.setTotalTripulantesMortos(totalTripulantesMortos);

        return ResponseEntity.ok(naveResponseDTO);
    }

    public ResponseEntity<?> apagaNave(Long id) {
        NaveEntity naveEntity = this.naveRepository.findById(id).orElse(null);
        if (naveEntity == null) {
            return ResponseEntity.notFound().build();
        }
        naveRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    public ResponseEntity<?> atualizaNave(Long idNave, NaveRequestDTO naveRequestDTO) {

        NaveEntity naveEntity = this.naveRepository.findById(idNave).orElse(null);

        if (naveEntity == null) {
            return ResponseEntity.notFound().build();
        }
        naveEntity.atualizaNave(naveRequestDTO);
        if (naveRequestDTO.getListaDeTripulantes() != null) {
            List<TripulanteEntity> tripulanteEntityList = naveRequestDTO.getListaDeTripulantes()
                .stream().map(id -> this.tripulanteRepository.findById(id).orElse(null)).toList();
            naveEntity.setListaDeTripulantes(tripulanteEntityList);
        }
        this.naveRepository.save(naveEntity);
        return ResponseEntity.ok(naveEntity);
    }
}
