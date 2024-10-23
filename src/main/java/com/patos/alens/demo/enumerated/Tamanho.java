package com.patos.alens.demo.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A classe Tamanho é responsável por representar o tamanho de uma nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Getter
@AllArgsConstructor
public enum Tamanho {
    PEQUENA("Pequena"),
    MEDIA("Média"),
    GRANDE("Grande"),
    COLOSSAL("Colossal");

    private final String nome;
}
