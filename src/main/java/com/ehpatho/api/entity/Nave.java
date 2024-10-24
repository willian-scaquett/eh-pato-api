package com.ehpatho.api.entity;

import com.ehpatho.api.dto.NaveRequestDTO;
import com.ehpatho.api.enumerated.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * A classe Nave é responsável por representar a tabela nave do banco de dados,
 * sendo que cada instância dessa entidade corresponde a uma linha da tabela.
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Data
@NoArgsConstructor
@Entity
public class Nave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column
    private Cor cor;

    @Enumerated(EnumType.STRING)
    @Column
    private Tamanho tamanho;

    @Enumerated(EnumType.STRING)
    @Column
    private LocalQueda localQueda;

    @Column
    @Enumerated(EnumType.STRING)
    private Armamento armamento;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;

    @Column
    @Enumerated(EnumType.STRING)
    private GrauAvaria grauAvaria;

    @Column
    @Enumerated(EnumType.STRING)
    private PotencialTecnologico potencialTecnologico;

    @Column
    private Integer totalTripulanteBem;

    @Column
    private Integer totalTripulanteFerido;

    @Column
    private Integer totalTripulanteFoiComDeus;

    @Column
    @Enumerated(EnumType.STRING)
    private Periculosidade periculosidade;

    @Column
    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    @CreationTimestamp
    @Column
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    @Column
    private LocalDateTime atualizadoEm;

    public Nave(NaveRequestDTO naveRequestDTO) {
        this.nome = naveRequestDTO.getNome();
        this.cor = naveRequestDTO.getCor();
        this.tamanho = naveRequestDTO.getTamanho();
        this.localQueda = naveRequestDTO.getLocalQueda();
        this.armamento = naveRequestDTO.getArmamento();
        this.tipoCombustivel = naveRequestDTO.getTipoCombustivel();
        this.totalTripulanteBem = naveRequestDTO.getTotalTripulanteBem();
        this.totalTripulanteFerido = naveRequestDTO.getTotalTripulanteFerido();
        this.totalTripulanteFoiComDeus = naveRequestDTO.getTotalTripulanteFoiComDeus();
        this.grauAvaria = naveRequestDTO.getGrauAvaria();
        this.potencialTecnologico = naveRequestDTO.getPotencialTecnologico();
        this.criadoEm = LocalDateTime.now();
    }

    public void editarNave(NaveRequestDTO dto) {
        if (dto.getNome() != null && !dto.getNome().isEmpty()) {
            this.nome = dto.getNome();
        }
        if (dto.getCor() != null) {
            this.cor = dto.getCor();
        }
        if (dto.getTamanho() != null) {
            this.tamanho = dto.getTamanho();
        }
        if (dto.getLocalQueda() != null) {
            this.localQueda = dto.getLocalQueda();
        }
        if (dto.getArmamento() != null) {
            this.armamento = dto.getArmamento();
        }
        if (dto.getTipoCombustivel() != null) {
            this.tipoCombustivel = dto.getTipoCombustivel();
        }
        if (dto.getTotalTripulanteBem() >= 0) {
            this.totalTripulanteBem = dto.getTotalTripulanteBem();
        }
        if (dto.getTotalTripulanteFerido() >= 0) {
            this.totalTripulanteFerido = dto.getTotalTripulanteFerido();
        }
        if (dto.getTotalTripulanteFoiComDeus() >= 0) {
            this.totalTripulanteFoiComDeus = dto.getTotalTripulanteFoiComDeus();
        }
        if (dto.getGrauAvaria() != null) {
            this.grauAvaria = dto.getGrauAvaria();
        }
        if (dto.getPotencialTecnologico() != null) {
            this.potencialTecnologico = dto.getPotencialTecnologico();
        }
        this.atualizadoEm = LocalDateTime.now();
    }
}
