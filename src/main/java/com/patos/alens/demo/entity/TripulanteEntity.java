package com.patos.alens.demo.entity;

import com.patos.alens.demo.enumerated.EstadoTripulante;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * A classe TripulanteEntity é responsável por  representar a tabela tripulante do
 * banco de dados, sendo que cada instancia dessa entidade corresponde a uma linha da tabela.
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Entity
@Table(name = "tripulante")
@Getter
@Setter
public class TripulanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tripulante")
    private Long idTripulante;
    @Column(name = "nome_tripulante", length = 100)
    private String nomeTripulante;
    @Column(name = "estado_tripulante", length = 50)
    @Enumerated(EnumType.STRING)
    private EstadoTripulante estadoTripulante;
    @CreationTimestamp
    @Column(name = "criado_em")
    private LocalDateTime criadoEm;
    @UpdateTimestamp
    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    public boolean estaVivo() {
        return !estadoTripulante.equals(EstadoTripulante.FOI_COM_DEUS);
    }
}
