package com.patos.alens.demo.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A classe TipoCombustivel é responsável por representar o tipo de combustivel de uma nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Getter
@AllArgsConstructor
public enum TipoCombustivel {
    ESPRESSO_QUANTICO("Espresso Quântico"),
    FALHA_GRAVITACIONAL("Falha Gravitacional"),
    GERADOR_PROBABILIDADE_INFINITA("Gerador de Probabilidades Infinitas"),
    LAGRIMAS_DE_UNICORNIO("Lágrimas de Unicórnio"),
    MATERIA_ESCURA("Matéria Escura"),
    PLUTONIO("Plutônio");

    private final String nome;
}
