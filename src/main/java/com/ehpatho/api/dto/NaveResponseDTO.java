package com.ehpatho.api.dto;

import com.ehpatho.api.entity.Nave;
import lombok.Data;

/**
 * A classe NaveResponseDTO é responsável por disponibilizar o json da entidade Nave na resposta dos endpoints
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Data
public class NaveResponseDTO {
    private Long id;
    private String nome;
    private String cor;
    private String tamanho;
    private String localQueda;
    private String armamento;
    private String tipoCombustivel;
    private String grauAvaria;
    private String potencialTecnologico;
    private String periculosidade;
    private String classificacao;
    private String tripulantes;

    public NaveResponseDTO(Nave nave) {
        this.id = nave.getId();
        this.nome = nave.getNome();
        this.cor = nave.getCor().getNome();
        this.tamanho = nave.getTamanho().getNome();
        this.localQueda = nave.getLocalQueda().getNome();
        this.armamento = nave.getArmamento().getNome();
        this.tipoCombustivel = nave.getTipoCombustivel().getNome();
        this.tripulantes = nave.getTotalTripulanteBem() + " / " + nave.getTotalTripulanteFerido() + " / " + nave.getTotalTripulanteFoiComDeus();
        this.grauAvaria = nave.getGrauAvaria().getNome();
        this.potencialTecnologico = nave.getPotencialTecnologico().getNome();
        this.periculosidade = nave.getPericulosidade().getNome();
        this.classificacao = nave.getClassificacao().getNome();
    }
}
