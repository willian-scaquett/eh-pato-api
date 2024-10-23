package com.patos.alens.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.patos.alens.demo.entity.Nave;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A classe {@link NaveResponseDTO} é responsável por disponibilizar a json de resposta do endpoint.
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
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
    private int totalTripulanteBem;
    private int totalTripulanteFerido;
    private int totalTripulanteFoiComDeus;
    private String tripulantes;

    public NaveResponseDTO(Nave nave) {
        this.id = nave.getId();
        this.nome = nave.getNome();
        this.cor = nave.getCor().getNome();
        this.tamanho = nave.getTamanho().getNome();
        this.localQueda = nave.getLocalQueda().getNome();
        this.armamento = nave.getArmamento().getNome();
        this.tipoCombustivel = nave.getTipoCombustivel().getNome();
        this.grauAvaria = nave.getGrauAvaria().getNome();
        this.potencialTecnologico = nave.getPotencialTecnologico().getNome();
        this.periculosidade = nave.getPericulosidade().getNome();
        this.classificacao = nave.getClassificacao().getNome();
        this.totalTripulanteBem = nave.getTotalTripulanteBem();
        this.totalTripulanteFerido = nave.getTotalTripulanteFerido();
        this.totalTripulanteFoiComDeus = nave.getTotalTripulanteFoiComDeus();
        this.tripulantes = totalTripulanteBem + " / " + totalTripulanteFerido + " / " + totalTripulanteFoiComDeus;
    }
}
