package com.patos.alens.demo.service;

import com.patos.alens.demo.dto.NaveRequestDTO;
import com.patos.alens.demo.dto.NaveResponseDTO;
import com.patos.alens.demo.entity.Nave;
import com.patos.alens.demo.repository.NaveRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NaveService {

    @Autowired
    NaveRepository naveRepository;

    public List<NaveResponseDTO> listaNaves() {
        List<NaveResponseDTO> response = new ArrayList<>();

        naveRepository.findAll().forEach(nave -> response.add(new NaveResponseDTO(nave)));

        return response;
    }

    public ResponseEntity<?> criaNave(NaveRequestDTO naveRequestDTO) {

        Nave nave = new Nave();
        nave.setPotencialTecnologico(naveRequestDTO.getPotencialTecnologico());
        nave.setArmamento(naveRequestDTO.getArmamento());
        nave.setCor(naveRequestDTO.getCor());
        nave.setTipoCombustivel(naveRequestDTO.getTipoCombustivel());
        nave.setGrauAvaria(naveRequestDTO.getGrauAvaria());
        nave.setLocalQueda(naveRequestDTO.getLocalQueda());
        nave.setNome(naveRequestDTO.getNome());

        naveRepository.save(nave);

        return ResponseEntity.ok(nave);

    }

    public ResponseEntity<?> buscaNavePeloId(Long id) {
        Nave nave = this.naveRepository.findById(id).orElse(null);

        if (nave == null) {
            return ResponseEntity.notFound().build();
        }

        NaveResponseDTO naveResponseDTO = new NaveResponseDTO();
        naveResponseDTO.setNome(nave.getNome());
        naveResponseDTO.setCor(nave.getCor().getNome());
        naveResponseDTO.setLocalQueda(nave.getLocalQueda().getNome());
        naveResponseDTO.setArmamento(nave.getArmamento().getNome());
        naveResponseDTO.setTipoCombustivel(nave.getTipoCombustivel().getDescricao());
        naveResponseDTO.setGrauAvaria(nave.getGrauAvaria().getDescricao());
        naveResponseDTO.setPotencialTecnologico(nave.getPotencialTecnologico().getDescricao());
        naveResponseDTO.setTotalTripulanteBem(nave.getTotalTripulanteBem());
        naveResponseDTO.setTotalTripulanteFerido(nave.getTotalTripulanteFerido());
        naveResponseDTO.setTotalTripulanteFoiComDeus(nave.getTotalTripulanteFoiComDeus());

        return ResponseEntity.ok(naveResponseDTO);
    }

    public ResponseEntity<?> apagaNave(Long id) {
        Nave nave = this.naveRepository.findById(id).orElse(null);
        if (nave == null) {
            return ResponseEntity.notFound().build();
        }
        naveRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    public ResponseEntity<?> atualizaNave(Long idNave, NaveRequestDTO naveRequestDTO) {

        Nave nave = this.naveRepository.findById(idNave).orElse(null);

        if (nave == null) {
            return ResponseEntity.notFound().build();
        }
        nave.atualizaNave(naveRequestDTO);

        this.naveRepository.save(nave);
        return ResponseEntity.ok(nave);
    }
}
