package com.patos.alens.demo.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A classe LocalQueda é responsável por disponibilizar onde a máquina caiu
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Getter
@AllArgsConstructor
public enum LocalQueda {
    AMERICA("América", 1),
    AFRICA("África", 2),
    ASIA("Ásia", 4),
    EUROPA("Europa", 2),
    OCEANIA("Oceania", 4),
    OCEANO_ATLANTICO("Oceano Atlântico", 6),
    OCEANO_PACIFICO("Oceano Pacífico", 7),
    OCEANO_INDICO("Oceano Índico", 8),
    OCEANO_GLACIAL_ANTARTICO("Oceano Glacial Antártico", 10),
    OCEANO_GLACIAL_ARTICO("Oceano Glacial Ártico", 10);

    private final String nome;
    private final int perigo;
}
