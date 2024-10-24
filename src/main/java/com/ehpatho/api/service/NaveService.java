package com.ehpatho.api.service;

import com.ehpatho.api.dto.ListsValoresSelectDTO;
import com.ehpatho.api.dto.NaveRequestDTO;
import com.ehpatho.api.dto.NaveResponseDTO;
import com.ehpatho.api.dto.ValoresSelectDTO;
import com.ehpatho.api.entity.Nave;
import com.ehpatho.api.enumerated.*;
import com.ehpatho.api.repository.NaveRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe NaveService é responsável por disponibilizar a regra de negócio do CRUD de nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Slf4j
@Service
public class NaveService {

    private final NaveRepository naveRepository;
    private final NaveClassificador naveClassificador;

    public NaveService(NaveRepository naveRepository, NaveClassificador naveClassificador) {
        this.naveRepository = naveRepository;
        this.naveClassificador = naveClassificador;
    }

    public List<NaveResponseDTO> listaNaves() {
        //Busca todos os registros da entidade Nave e retorna numa lista de NaveResponseDTO
        log.info("Buscando todas as naves");
        List<NaveResponseDTO> response = new ArrayList<>();
        naveRepository.findAll().forEach(nave -> response.add(new NaveResponseDTO(nave)));
        log.info("Total de naves encontradas: {}", response.size());
        return response;
    }

    public NaveResponseDTO criarNave(NaveRequestDTO naveRequestDTO) throws ResponseStatusException {
        log.info("Criando nova nave com nome: {}", naveRequestDTO.getNome());

        //Se o nome já existe, retorna um bad request
        if (naveRepository.existsByNome(naveRequestDTO.getNome())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome de nave já existente");
        }

        //Define os atributos categoria e periculosidade da nave criada conforme o DTO
        Nave nave = naveClassificador.definirCategoriaEPericulosidade(new Nave(naveRequestDTO));

        //Salva a nova nave no banco e a retorna em um DTO
        return new NaveResponseDTO(naveRepository.save(nave));
    }

    public void apagarNave(Long id) throws BadRequestException {
        //Busca a nave a ser apagada
        Nave nave = this.naveRepository.findById(id).orElse(null);
        //Caso ela não exista, retorna um not found
        if (nave == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nave não encontrada");
        }
        //Apaga a nave
        naveRepository.deleteById(id);
    }

    public NaveResponseDTO editarNave(Long idNave, NaveRequestDTO naveRequestDTO) throws ResponseStatusException {
        //Busca a nave a ser editada
        Nave nave = this.naveRepository.findById(idNave).orElse(null);

        //Caso a nave não exista, retorna um not found
        if (nave == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nave não encontrada");
        }

        //Caso o nome de nave já exista, retorna um bad request
        if (naveRepository.existsByNomeAndIdNot(naveRequestDTO.getNome(), idNave)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome de nave já existente");
        }

        //Define novos dados da nave
        nave.editarNave(naveRequestDTO);
        //Reclassifica a nave com os novos dados
        nave = naveClassificador.definirCategoriaEPericulosidade(nave);

        //Salva a nave editada no banco e a retorna em um DTO
        return new NaveResponseDTO(naveRepository.save(nave));
    }

    public Nave buscaNavePeloId(Long id) throws ResponseStatusException {
        //Busca nave pelo ID
        Nave nave = this.naveRepository.findById(id).orElse(null);
        //Caso ela não exista, retorna um not found
        if (nave == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nave não encontrada");
        }
        return nave;
    }

    /**
     * Adiciona na lista de cada campo os valores dos enums a serem usados nos selects do front-end
     * Dessa forma, evitam-se informações duplicadas e facilita a manutenção
     */
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

        for (Tamanho tamanho : Tamanho.values()) {
            response.getTamanhos().add(new ValoresSelectDTO(tamanho.name(), tamanho.getNome()));
        }

        return response;
    }
}
