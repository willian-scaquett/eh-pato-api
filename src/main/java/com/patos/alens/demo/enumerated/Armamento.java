package com.patos.alens.demo.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A classe Armamento é responsável por disponibilizar o poder de armamento que uma nave tem
 *
 * @author Kaique Queiros kaique_q@outloom.com
 */
@Getter
@AllArgsConstructor
public enum Armamento {
    BOMBA("Bomba"),
    CANHAO_LAVA("Canhão de lava"),
    LASER("Laser"),
    MISSEL("Míssel"),
    OGIVA_NUCLEAR("Ogiva Nuclear");

    private String nome;
}
