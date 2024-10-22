package com.patos.alens.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.patos.alens.demo.enumerated.CorNave;
import com.patos.alens.demo.enumerated.GrauAvaria;
import com.patos.alens.demo.enumerated.LocalQueda;
import com.patos.alens.demo.enumerated.PoderioBelico;
import com.patos.alens.demo.enumerated.PotencialTecnologico;
import com.patos.alens.demo.enumerated.TipoCombustivel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;
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
