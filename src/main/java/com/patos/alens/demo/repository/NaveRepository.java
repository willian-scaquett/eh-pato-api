package com.patos.alens.demo.repository;

import com.patos.alens.demo.entity.Nave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaveRepository extends JpaRepository<Nave, Long> {

    boolean existsByNome(String nome);

}
