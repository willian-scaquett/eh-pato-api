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
        naveEntity.setArmamento(naveRequestDTO.getArmamento());
        naveEntity.setCor(naveRequestDTO.getCor());
        naveEntity.setTipoCombustivel(naveRequestDTO.getTipoCombustivel());
        naveEntity.setGrauAvaria(naveRequestDTO.getGrauAvaria());
        naveEntity.setLocalQueda(naveRequestDTO.getLocalQueda());
        naveEntity.setNome(naveRequestDTO.getNome());

        naveRepository.save(naveEntity);

        return ResponseEntity.ok(naveEntity);

    }

    public ResponseEntity<?> buscaNavePeloId(Long id) {
        NaveEntity naveEntity = this.naveRepository.findById(id).orElse(null);

        if (naveEntity == null) {
            return ResponseEntity.notFound().build();
        }

        NaveResponseDTO naveResponseDTO = new NaveResponseDTO();
        naveResponseDTO.setNomeNave(naveEntity.getNome());
        naveResponseDTO.setCorNave(naveEntity.getCor().getNome());
        naveResponseDTO.setLocalQuedaNave(naveEntity.getLocalQueda().getNome());
        naveResponseDTO.setArmamentoNave(naveEntity.getArmamento().getNome());
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
