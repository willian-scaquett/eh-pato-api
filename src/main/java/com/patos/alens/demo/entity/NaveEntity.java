package com.patos.alens.demo.entity;

import com.patos.alens.demo.dto.NaveRequestDTO;
import com.patos.alens.demo.enumerated.*;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * A classe NaveEntity é responsável por  representar a tabela nave do
 * banco de dados, sendo que cada instância dessa entidade corresponde a uma linha da tabela.
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Entity
@Data
@Table(name = "nave")
public class NaveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nave", nullable = false)
    private Long idNave;
    @Column(name = "nome_nave", length = 50, nullable = false, unique = true)
    private String nomeNave;
    @Enumerated(EnumType.STRING)
    @Column(name = "cor_nave", length = 50)
    private CorNave corNave;
    @Enumerated(EnumType.STRING)
    @Column(name = "local_queda_nave", length = 50)
    private LocalQueda localQuedaNave;
    @Column(name = "armamento_nave", length = 100)
    @Enumerated(EnumType.STRING)
    private PoderioBelico armamentoNave;
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
        if (dto.getNomeNave() != null) {
            this.setNomeNave(dto.getNomeNave());
        }
        if (dto.getCorNave() != null) {
            this.setCorNave(dto.getCorNave());
        }
        if (dto.getLocalQuedaNave() != null) {
            this.setLocalQuedaNave(dto.getLocalQuedaNave());
        }
        if (dto.getArmamentoNave() != null) {
            this.setArmamentoNave(dto.getArmamentoNave());
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
