package com.patos.alens.demo.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * O enumerador CorNave é responsável por disponibilizar as possibildiades de cores para as naves
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
