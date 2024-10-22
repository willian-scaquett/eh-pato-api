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
import lombok.Data;

/**
 * A classe NaveRequestDTO é responsavel por representar o que corpo da requisição feita a api para
 * cadastrar uma nave ou editar
 *
 * @author Kaique Queiros kaique.q@outlook.com
 */
@JsonSerialize
@Data
public class NaveRequestDTO {

    private String nomeNave;
    private CorNave corNave;
    private LocalQueda localQuedaNave;
    private PoderioBelico armamentoNave;
    @Schema(example = "LAGRIMAS_DE_UNICORNIO")
    private TipoCombustivel tipoCombustivel;
    @Schema(example = "PERDA_TOTAL")
    private GrauAvaria grauAvaria;
    @Schema(example = "AVANCADA")
    private PotencialTecnologico potencialTecnologico;
    private Long totalTripulanteBem;
    private Long totalTripulanteFerido;
    private Long totalTripulanteFoiComDeus;
    @JsonIgnore
    private LocalDateTime criadoEm;
    @JsonIgnore
    private LocalDateTime atualizadoEm;

    public NaveRequestDTO(PotencialTecnologico potencialTecnologico, GrauAvaria grauAvaria,
         TipoCombustivel tipoCombustivel, PoderioBelico armamentoNave,
        LocalQueda localQuedaNave, CorNave corNave, String nomeNave) {
        this.potencialTecnologico = potencialTecnologico;
        this.grauAvaria = grauAvaria;
        this.tipoCombustivel = tipoCombustivel;
        this.armamentoNave = armamentoNave;
        this.localQuedaNave = localQuedaNave;
        this.corNave = corNave;
        this.nomeNave = nomeNave;
    }

}
