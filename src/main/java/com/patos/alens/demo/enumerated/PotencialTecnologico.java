package com.patos.alens.demo.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * O enumerador PotencialTecnologico é responsável por representar qual o potencial tecnologico de uma nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Getter
@AllArgsConstructor
public enum PotencialTecnologico {
    PRIMITIVA("Primitiva"),
    AVANCADA("Avançada"),
    SOBERANA("Soberana"),
    DIVINA("Divina"),
    TRANSCENDENTE("Transcendente");

    private final String nome;
}
