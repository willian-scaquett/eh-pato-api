package com.patos.alens.demo.entity;

import com.patos.alens.demo.enumerated.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "nave")
@Getter
@Setter
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
    @Column(name = "criado_em")
    private LocalDateTime criadoEm;
    @UpdateTimestamp
    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

}
