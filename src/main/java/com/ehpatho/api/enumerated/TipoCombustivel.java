package com.ehpatho.api.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * O enumerador TipoCombustivel é responsável por representar o tipo de combustível de uma nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Getter
@AllArgsConstructor
public enum TipoCombustivel {
    PLUTONIO("Plutônio", 2, 10),
    LAGRIMAS_DE_UNICORNIO("Lágrimas de Unicórnio", 4, 0),
    MATERIA_ESCURA("Matéria Escura", 6, 6),
    FALHA_GRAVITACIONAL("Falha Gravitacional", 7, 2),
    ESPRESSO_QUANTICO("Espresso Quântico", 8, 4),
    GERADOR_PROBABILIDADE_INFINITA("Gerador de Probabilidades Infinitas", 10, 8);

    private final String nome;
    private final int poder;
    private final int perigo;
}
