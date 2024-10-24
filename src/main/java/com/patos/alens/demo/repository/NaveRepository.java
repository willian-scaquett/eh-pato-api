package com.patos.alens.demo.repository;

import com.patos.alens.demo.entity.Nave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A classe NaveRepository é por realizar as consultas ao banco de dados
 * da entidade Nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Repository
public interface NaveRepository extends JpaRepository<Nave, Long> {

    boolean existsByNome(String nome);

    boolean existsByNomeAndIdNot(String nome, Long id);

}
