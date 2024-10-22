package com.patos.alens.demo.service;

import com.patos.alens.demo.dto.NaveRequestDTO;
import com.patos.alens.demo.dto.NaveResponseDTO;
import com.patos.alens.demo.entity.NaveEntity;
import com.patos.alens.demo.repository.NaveRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NaveService {

    @Autowired
    NaveRepository naveRepository;

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

        naveRepository.save(naveEntity);

        return ResponseEntity.ok(naveEntity);

    }

    public ResponseEntity<?> buscaNavePeloId(Long id) {
        NaveEntity naveEntity = this.naveRepository.findById(id).orElse(null);

        if (naveEntity == null) {
            return ResponseEntity.notFound().build();
        }

        NaveResponseDTO naveResponseDTO = new NaveResponseDTO();
        naveResponseDTO.setNomeNave(naveEntity.getNomeNave());
        naveResponseDTO.setCorNave(naveEntity.getCorNave().getNome());
        naveResponseDTO.setLocalQuedaNave(naveEntity.getLocalQuedaNave().getNome());
        naveResponseDTO.setArmamentoNave(naveEntity.getArmamentoNave().getNome());
        naveResponseDTO.setTipoCombustivel(naveEntity.getTipoCombustivel().getDescricao());
        naveResponseDTO.setGrauAvaria(naveEntity.getGrauAvaria().getDescricao());
        naveResponseDTO.setPotencialTecnologico(naveEntity.getPotencialTecnologico().getDescricao());
        naveResponseDTO.setTotalTripulanteBem(naveEntity.getTotalTripulanteBem());
        naveResponseDTO.setTotalTripulanteFerido(naveEntity.getTotalTripulanteFerido());
        naveResponseDTO.setTotalTripulanteFoiComDeus(naveEntity.getTotalTripulanteFoiComDeus());
        naveResponseDTO.setCriadoEm(naveEntity.getCriadoEm());
        naveResponseDTO.setAtualizadoEm(naveEntity.getAtualizadoEm());

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

        this.naveRepository.save(naveEntity);
        return ResponseEntity.ok(naveEntity);
    }
}
