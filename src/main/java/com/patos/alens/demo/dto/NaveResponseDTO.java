package com.patos.alens.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

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
    private String localQueda;
    private String armamento;
    private String tipoCombustivel;
    private String grauAvaria;
    private String potencialTecnologico;
    private Long totalTripulanteBem;
    private Long totalTripulanteFerido;
    private Long totalTripulanteFoiComDeus;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public NaveResponseDTO(Nave nave) {
        this.id = nave.getId();
        this.id = nave.getId();
        this.id = nave.getId();
        this.id = nave.getId();
        this.id = nave.getId();
        this.id = nave.getId();
        this.id = nave.getId();
        this.id = nave.getId();
        this.id = nave.getId();
        this.id = nave.getId();
    }
}
