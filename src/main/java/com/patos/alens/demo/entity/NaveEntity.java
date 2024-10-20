package com.patos.alens.demo.entity;

import com.patos.alens.demo.enumerated.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
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
    private String armamentoNave;
    @Column(name = "tipo_combustivel", length = 50)
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;
    @ManyToMany
    @JoinTable(
            name = "nave_tripulante",
            joinColumns = {@JoinColumn(name = "id_nave", referencedColumnName = "id_nave")},
            inverseJoinColumns = {@JoinColumn(name = "id_tripulante", referencedColumnName = "id_tripulante")}
    )
    private List<TripulanteEntity> listaDeTripulantes;
    @Column(name = "grau_avaria", length = 50)
    @Enumerated(EnumType.STRING)
    private GrauAvaria grauAvaria;
    @Column(name = "potencial_tecnologico", length = 50)
    @Enumerated(EnumType.STRING)
    private PotencialTecnologico potencialTecnologico;
    @CreationTimestamp
    @Column(name = "criado_em")
    private LocalDateTime criadoEm;
    @UpdateTimestamp
    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;


    public Long getIdNave() {
        return idNave;
    }

    public void setIdNave(Long idNave) {
        this.idNave = idNave;
    }

    public String getNomeNave() {
        return nomeNave;
    }

    public void setNomeNave(String nomeNave) {
        this.nomeNave = nomeNave;
    }

    public CorNave getCorNave() {
        return corNave;
    }

    public void setCorNave(CorNave corNave) {
        this.corNave = corNave;
    }

    public LocalQueda getLocalQuedaNave() {
        return localQuedaNave;
    }

    public void setLocalQuedaNave(LocalQueda localQuedaNave) {
        this.localQuedaNave = localQuedaNave;
    }

    public String getArmamentoNave() {
        return armamentoNave;
    }

    public void setArmamentoNave(String armamentoNave) {
        this.armamentoNave = armamentoNave;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public List<TripulanteEntity> getListaDeTripulantes() {
        return listaDeTripulantes;
    }

    public void setListaDeTripulantes(List<TripulanteEntity> listaDeTripulantes) {
        this.listaDeTripulantes = listaDeTripulantes;
    }

    public GrauAvaria getGrauAvaria() {
        return grauAvaria;
    }

    public void setGrauAvaria(GrauAvaria grauAvaria) {
        this.grauAvaria = grauAvaria;
    }

    public PotencialTecnologico getPotencialTecnologico() {
        return potencialTecnologico;
    }

    public void setPotencialTecnologico(PotencialTecnologico potencialTecnologico) {
        this.potencialTecnologico = potencialTecnologico;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
