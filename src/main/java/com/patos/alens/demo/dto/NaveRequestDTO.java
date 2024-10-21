package com.patos.alens.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.patos.alens.demo.enumerated.CorNave;
import com.patos.alens.demo.enumerated.GrauAvaria;
import com.patos.alens.demo.enumerated.LocalQueda;
import com.patos.alens.demo.enumerated.PotencialTecnologico;
import com.patos.alens.demo.enumerated.TipoCombustivel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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
    private String armamentoNave;
    @Schema(example = "LAGRIMAS_DE_UNICORNIO")
    private TipoCombustivel tipoCombustivel;
    private List<Long> listaDeTripulantes;
    @Schema(example = "PERDA_TOTAL")
    private GrauAvaria grauAvaria;
    @Schema(example = "AVANCADA")
    private PotencialTecnologico potencialTecnologico;
    @JsonIgnore
    private LocalDateTime criadoEm;
    @JsonIgnore
    private LocalDateTime atualizadoEm;

    public NaveRequestDTO(PotencialTecnologico potencialTecnologico, GrauAvaria grauAvaria,
        List<Long> listaDeTripulantes, TipoCombustivel tipoCombustivel, String armamentoNave,
        LocalQueda localQuedaNave, CorNave corNave, String nomeNave) {
        this.potencialTecnologico = potencialTecnologico;
        this.grauAvaria = grauAvaria;
        this.listaDeTripulantes = listaDeTripulantes;
        this.tipoCombustivel = tipoCombustivel;
        this.armamentoNave = armamentoNave;
        this.localQuedaNave = localQuedaNave;
        this.corNave = corNave;
        this.nomeNave = nomeNave;
    }

}
