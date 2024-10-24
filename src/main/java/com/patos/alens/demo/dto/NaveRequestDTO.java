package com.patos.alens.demo.dto;

import com.patos.alens.demo.enumerated.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * A classe NaveRequestDTO é responsável por representar o que corpo da requisição feita à api para
 * cadastrar uma nave ou editar.
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Data
public class NaveRequestDTO {
    private String nome;
    @Schema(example = "AMARELA")
    private Cor cor;
    @Schema(example = "PEQUENA")
    private Tamanho tamanho;
    @Schema(example = "AMERICA")
    private LocalQueda localQueda;
    @Schema(example = "BOMBA")
    private Armamento armamento;
    @Schema(example = "ESPRESSO_QUANTICO")
    private TipoCombustivel tipoCombustivel;
    @Schema(example = "SEM_AVARIAS")
    private GrauAvaria grauAvaria;
    @Schema(example = "PRIMITIVA")
    private PotencialTecnologico potencialTecnologico;
    private int totalTripulanteBem;
    private int totalTripulanteFerido;
    private int totalTripulanteFoiComDeus;
}
