package com.patos.alens.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.patos.alens.demo.entity.TripulanteEntity;
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

@Data
@NoArgsConstructor
@JsonSerialize
public class NaveResponseDTO {
    private String nomeNave;
    private CorNave corNave;
    private LocalQueda localQuedaNave;
    private PoderioBelico armamentoNave;
    @Schema(example = "LAGRIMAS_DE_UNICORNIO")
    private TipoCombustivel tipoCombustivel;
    private List<TripulanteEntity> listaDeTripulantes;
    @Schema(example = "PERDA_TOTAL")
    private GrauAvaria grauAvaria;
    @Schema(example = "AVANCADA")
    private PotencialTecnologico potencialTecnologico;
    @JsonIgnore
    private LocalDateTime criadoEm;
    @JsonIgnore
    private LocalDateTime atualizadoEm;
    private Long totalTripulanteBem;
    private Long totalTripulanteFerido;
    private Long totalTripulanteFoiComDeus;

    public NaveResponseDTO(PotencialTecnologico potencialTecnologico, GrauAvaria grauAvaria, List<TripulanteEntity> listaDeTripulantes, TipoCombustivel tipoCombustivel, PoderioBelico armamentoNave, LocalQueda localQuedaNave, CorNave corNave, String nomeNave) {
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
