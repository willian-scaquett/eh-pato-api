package com.ehpatho.api.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * O enumerador PotencialTecnologico é responsável por representar qual o potencial tecnológico de uma nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Getter
@AllArgsConstructor
public enum PotencialTecnologico {
    PRIMITIVA("Primitiva", 2),
    AVANCADA("Avançada", 4),
    SOBERANA("Soberana", 6),
    DIVINA("Divina", 8),
    TRANSCENDENTE("Transcendente", 10);

    private final String nome;
    private final int bonus;
}
