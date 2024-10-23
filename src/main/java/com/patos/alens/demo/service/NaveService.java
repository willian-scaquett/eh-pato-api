package com.patos.alens.demo.service;

import com.patos.alens.demo.dto.ListsValoresSelectDTO;
import com.patos.alens.demo.dto.NaveRequestDTO;
import com.patos.alens.demo.dto.NaveResponseDTO;
import com.patos.alens.demo.dto.ValoresSelectDTO;
import com.patos.alens.demo.entity.Nave;
import com.patos.alens.demo.enumerated.*;
import com.patos.alens.demo.repository.NaveRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NaveService {

    private final NaveRepository naveRepository;

    public NaveService(NaveRepository naveRepository) {
        this.naveRepository = naveRepository;
    }

    public List<NaveResponseDTO> listaNaves() {
        List<NaveResponseDTO> response = new ArrayList<>();

        naveRepository.findAll().forEach(nave -> response.add(new NaveResponseDTO(nave)));

        return response;
    }

    public Nave criaNave(NaveRequestDTO naveRequestDTO) throws BadRequestException {

        boolean naveExiste = naveRepository.existsByNome(naveRequestDTO.getNome());

        if (naveExiste) {
            throw new BadRequestException();
        }

        Nave nave = new Nave();
        nave.setPotencialTecnologico(naveRequestDTO.getPotencialTecnologico());
        nave.setArmamento(naveRequestDTO.getArmamento());
        nave.setCor(naveRequestDTO.getCor());
        nave.setTipoCombustivel(naveRequestDTO.getTipoCombustivel());
        nave.setGrauAvaria(naveRequestDTO.getGrauAvaria());
        nave.setLocalQueda(naveRequestDTO.getLocalQueda());
        nave.setNome(naveRequestDTO.getNome());

        naveRepository.save(nave);

        return nave;

    }

    public ResponseEntity<?> buscaNavePeloId(Long id) {
        Nave nave = this.naveRepository.findById(id).orElse(null);

        if (nave == null) {
            return ResponseEntity.notFound().build();
        }

        NaveResponseDTO naveResponseDTO = new NaveResponseDTO();
        naveResponseDTO.setId(nave.getId());
        naveResponseDTO.setNome(nave.getNome());
        naveResponseDTO.setCor(nave.getCor().getNome());
        naveResponseDTO.setLocalQueda(nave.getLocalQueda().getNome());
        naveResponseDTO.setArmamento(nave.getArmamento().getNome());
        naveResponseDTO.setTipoCombustivel(nave.getTipoCombustivel().getNome());
        naveResponseDTO.setGrauAvaria(nave.getGrauAvaria().getNome());
        naveResponseDTO.setPotencialTecnologico(nave.getPotencialTecnologico().getNome());
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

    public ResponseEntity<?> atualizaNave(Long idNave, NaveRequestDTO naveRequestDTO) throws BadRequestException {

        Nave nave = this.naveRepository.findById(idNave).orElse(null);

        if (nave == null) {
            return ResponseEntity.notFound().build();
        }

        boolean naveExiste = naveRepository.existsByNome(naveRequestDTO.getNome());

        if (naveExiste) {
            throw new BadRequestException();
        }
        nave.atualizaNave(naveRequestDTO);

        this.naveRepository.save(nave);
        return ResponseEntity.ok(nave);
    }

    public ListsValoresSelectDTO getValoresSelectsCadastro() {
        ListsValoresSelectDTO response = new ListsValoresSelectDTO();

        for (Cor cor : Cor.values()) {
            response.getCores().add(new ValoresSelectDTO(cor.name(), cor.getNome()));
        }

        for (LocalQueda localQueda : LocalQueda.values()) {
            response.getLocais().add(new ValoresSelectDTO(localQueda.name(), localQueda.getNome()));
        }

        for (TipoCombustivel tipoCombustivel : TipoCombustivel.values()) {
            response.getCombustiveis().add(new ValoresSelectDTO(tipoCombustivel.name(), tipoCombustivel.getNome()));
        }

        for (GrauAvaria grauAvaria : GrauAvaria.values()) {
            response.getGraus().add(new ValoresSelectDTO(grauAvaria.name(), grauAvaria.getNome()));
        }

        for (PotencialTecnologico potencialTecnologico : PotencialTecnologico.values()) {
            response.getPotenciais().add(new ValoresSelectDTO(potencialTecnologico.name(), potencialTecnologico.getNome()));
        }

        for (Armamento armamento : Armamento.values()) {
            response.getArmamentos().add(new ValoresSelectDTO(armamento.name(), armamento.getNome()));
        }

        return response;
    }
}
