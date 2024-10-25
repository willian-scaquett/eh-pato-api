package com.ehpatho.api.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * O enumerador LocalQueda é responsável por disponibilizar os lugares onde a nave pode ter caído
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
