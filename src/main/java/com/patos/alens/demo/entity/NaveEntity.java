package com.patos.alens.demo.entity;

import com.patos.alens.demo.dto.NaveRequestDTO;
import com.patos.alens.demo.enumerated.CorNave;
import com.patos.alens.demo.enumerated.GrauAvaria;
import com.patos.alens.demo.enumerated.LocalQueda;
import com.patos.alens.demo.enumerated.PoderioBelico;
import com.patos.alens.demo.enumerated.PotencialTecnologico;
import com.patos.alens.demo.enumerated.TipoCombustivel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    @Column(name = "nome_nave", length = 50, nullable = false)
    private String nomeNave;
    @Enumerated(EnumType.STRING)
    @Column(name = "cor_nave", length = 50)
    private CorNave corNave;
    @Enumerated(EnumType.STRING)
    @Column(name = "local_queda_nave", length = 50)
    private LocalQueda localQuedaNave;
    @Column(name = "armamento_nave", length = 100)
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
    private Long totalTripulanteBem;
    private Long totalTripulanteFerido;
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
