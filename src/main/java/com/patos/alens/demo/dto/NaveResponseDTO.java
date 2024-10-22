package com.patos.alens.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A classe {@link NaveResponseDTO} é responsável por disponibilizar a json de resposta do endpoint.
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Data
@NoArgsConstructor
@JsonSerialize
public class NaveResponseDTO {
    private String nomeNave;
    private String corNave;
    private String localQuedaNave;
    private String armamentoNave;
    private String tipoCombustivel;
    private String grauAvaria;
    private String potencialTecnologico;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private Long totalTripulanteBem;
    private Long totalTripulanteFerido;
    private Long totalTripulanteFoiComDeus;

    /**
     * Inicializa uma nova resposta para nave.
     *
     * @param potencialTecnologico  potencial tecnologico
     * @param grauAvaria            grau avaria
     * @param tipoCombustivel       tipo combustivel
     * @param armamentoNave         armamento nave
     * @param localQuedaNave        local queda nave
     * @param corNave               cor nave
     * @param nomeNave              nome nave
     */
    public NaveResponseDTO(String potencialTecnologico, String grauAvaria, String tipoCombustivel, String armamentoNave, String localQuedaNave, String corNave, String nomeNave) {
        this.potencialTecnologico = potencialTecnologico;
        this.grauAvaria = grauAvaria;
        this.tipoCombustivel = tipoCombustivel;
        this.armamentoNave = armamentoNave;
        this.localQuedaNave = localQuedaNave;
        this.corNave = corNave;
        this.nomeNave = nomeNave;
    }

}
