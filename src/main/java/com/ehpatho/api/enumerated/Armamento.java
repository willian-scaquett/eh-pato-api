package com.ehpatho.api.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A classe Armamento é responsável por disponibilizar as armas que uma nave poder ter
 *
 * @author Kaique Queiros kaique_q@outloom.com
 */
@Getter
@AllArgsConstructor
public enum Armamento {
    BOMBA("Bomba", 2, 8),
    CANHAO_LAVA("Canhão de lava", 4, 10),
    MISSEL("Míssel", 6, 4),
    LASER("Laser", 8, 2),
    OGIVA_NUCLEAR("Ogiva Nuclear", 10, 6),
    SEM_ARMAS("Sem armas", 0, 0);

    private final String nome;
    private final int poder;
    private final int perigo;
}
