package com.patos.alens.demo.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * O enumerador GrauAvaria é responsável por disponibilizar os graus de avaria de uma nave pode ter
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Getter
@AllArgsConstructor
public enum GrauAvaria {
    SEM_AVARIAS("Sem Avarias", 0),
    PRATICAMENTE_INTACTA("Praticamente Intacta", 6),
    PARCIALMENTE_DESTRUIDA("Parcialmente Destruída", 15),
    MUITO_DESTRUIDA("Muito Destruída", 24),
    PERDA_TOTAL("Perda Total", 30);

    private final String nome;
    private final int punicao;
}
