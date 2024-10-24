package com.ehpatho.api.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * O enumerador Cor é responsável por disponibilizar as possibilidades de cores para as naves
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Getter
@AllArgsConstructor
public enum Cor {
    AMARELA("Amarela"),
    ANIL("Anil"),
    AZUL("Azul"),
    LARANJA("Laranja"),
    VERDE("Verde"),
    VERMELHA("Vermelha"),
    VIOLETA("Violeta");

    private final String nome;
}
