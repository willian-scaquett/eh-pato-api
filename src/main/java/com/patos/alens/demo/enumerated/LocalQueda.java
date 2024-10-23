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
    AMERICA("América"),
    AFRICA("África"),
    ASIA("Ásia"),
    EUROPA("Europa"),
    OCEANIA("Oceania"),
    OCEANO_ATLANTICO("Oceano Atlântico"),
    OCEANO_PACIFICO("Oceano Pacífico"),
    OCEANO_INDICO("Oceano Índico"),
    OCEANO_GLACIAL_ANTARTICO("Oceano Glacial Antártico"),
    OCEANO_GLACIAL_ARTICO("Oceano Glacial Ártico");

    private final String nome;
}
