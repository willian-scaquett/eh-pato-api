package com.ehpatho.api.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * O enumerador Periculosidade é responsável por representar o grau de periculosidade de uma nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Getter
@AllArgsConstructor
public enum Periculosidade {
    BAIXISSIMA("Baixíssima"),
    BAIXA("Baixa"),
    MEDIA("Média"),
    ALTA("Alta"),
    ALTISSIMA("Altíssima");

    private final String nome;
}
