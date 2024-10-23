package com.patos.alens.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.patos.alens.demo.enumerated.Cor;
import com.patos.alens.demo.enumerated.GrauAvaria;
import com.patos.alens.demo.enumerated.LocalQueda;
import com.patos.alens.demo.enumerated.Armamento;
import com.patos.alens.demo.enumerated.PotencialTecnologico;
import com.patos.alens.demo.enumerated.TipoCombustivel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A classe NaveRequestDTO é responsavel por representar o que corpo da requisição feita a api para
 * cadastrar uma nave ou editar.
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@JsonSerialize
@Data
@NoArgsConstructor
public class NaveRequestDTO {

    private String nome;
    private Cor cor;
    private LocalQueda localQueda;
    private Armamento armamento;
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

    /**
     * Inicializador de uma nova nave.
     *
     * @param potencialTecnologico potencial tecnologico
     * @param grauAvaria           grau avaria
     * @param tipoCombustivel      tipo combustivel
     * @param armamento            armamento
     * @param localQueda           local queda
     * @param cor                  cor
     * @param nome                 nome
     */
    public NaveRequestDTO(PotencialTecnologico potencialTecnologico, GrauAvaria grauAvaria,
                          TipoCombustivel tipoCombustivel, Armamento armamento, LocalQueda localQueda, Cor cor, String nome) {
        this.potencialTecnologico = potencialTecnologico;
        this.grauAvaria = grauAvaria;
        this.tipoCombustivel = tipoCombustivel;
        this.armamento = armamento;
        this.localQueda = localQueda;
        this.cor = cor;
        this.nome = nome;
    }

}
