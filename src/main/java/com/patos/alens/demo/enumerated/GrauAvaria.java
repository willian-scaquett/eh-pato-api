package com.patos.alens.demo.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * O enumerador GrauAvaria é responsável por disponibilizar qual é o grau de avaria de uma nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Getter
@AllArgsConstructor
public enum GrauAvaria {
    SEM_AVARIAS("Sem Avarias"),
    PRATICAMENTE_INTACTA("Praticamente Intacta"),
    PARCIALMENTE_DESTRUIDA("Parcialmente Destruída"),
    MUITO_DESTRUIDA("Muito Destruída"),
    PERDA_TOTAL("Perda Total");

    private final String nome;
}
