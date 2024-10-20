package com.patos.alens.demo.repository;

import com.patos.alens.demo.entity.TripulanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A classe TripulanteRepository é responsável por realizar as operaçoes no banco de dados da tabela tripulante
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Repository
public interface TripulanteRepository extends JpaRepository<TripulanteEntity, Long> {
}
