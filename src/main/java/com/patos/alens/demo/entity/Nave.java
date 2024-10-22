package com.patos.alens.demo.entity;

import com.patos.alens.demo.dto.NaveRequestDTO;
import com.patos.alens.demo.enumerated.*;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * A classe NaveEntity é responsável por representar a tabela nave do
 * banco de dados, sendo que cada instância dessa entidade corresponde a uma linha da tabela.
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Entity
@Data
@Table(name = "nave")
public class Nave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false, unique = true)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "cor", length = 50)
    private Cor cor;

    @Enumerated(EnumType.STRING)
    @Column(name = "local_queda", length = 50)
    private LocalQueda localQueda;

    @Column(name = "armamento", length = 100)
    @Enumerated(EnumType.STRING)
    private Armamento armamento;

    @Column(name = "tipo_combustivel", length = 50)
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;

    @Column(name = "grau_avaria", length = 50)
    @Enumerated(EnumType.STRING)
    private GrauAvaria grauAvaria;

    @Column(name = "potencial_tecnologico", length = 50)
    @Enumerated(EnumType.STRING)
    private PotencialTecnologico potencialTecnologico;

    @Column(name = "total_tripulante_bem")
    private Long totalTripulanteBem;

    @Column(name = "total_tripulante_ferido")
    private Long totalTripulanteFerido;

    @Column(name = "total_tripulante_foi_com_deus")
    private Long totalTripulanteFoiComDeus;

    @CreationTimestamp
    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    public void atualizaNave(NaveRequestDTO dto) {
        if (dto.getNome() != null) {
            this.setNome(dto.getNome());
        }
        if (dto.getCor() != null) {
            this.setCor(dto.getCor());
        }
        if (dto.getLocalQueda() != null) {
            this.setLocalQueda(dto.getLocalQueda());
        }
        if (dto.getArmamento() != null) {
            this.setArmamento(dto.getArmamento());
        }
        if (dto.getTipoCombustivel() != null) {
            this.setTipoCombustivel(dto.getTipoCombustivel());
        }
        if (dto.getGrauAvaria() != null) {
            this.setGrauAvaria(dto.getGrauAvaria());
        }
        if (dto.getPotencialTecnologico() != null) {
            this.setPotencialTecnologico(dto.getPotencialTecnologico());
        }
    }
}
