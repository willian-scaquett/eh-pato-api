package com.ehpatho.api.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * O enumerador Tamanho é responsável por representar o tamanho de uma nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Getter
@AllArgsConstructor
public enum Tamanho {
    PEQUENA("Pequena", 1),
    MEDIA("Média", 4),
    GRANDE("Grande", 7),
    COLOSSAL("Colossal", 10);

    private final String nome;
    private final int bonus;
}
