package com.patos.alens.demo.enumerated;

import java.util.Locale;

/**
 * A classe PoderioBelico é responsável por disponibilizar o poder de armamento que uma nave tem
 *
 * @author Kaique Queiros kaique_q@outloom.com
 */
public enum PoderioBelico {
    LASER("Laser"),
    MISSELE("Míssel"),
    MACHINE_GUN("Metralhadora"),
    RIFLE("Rifle"),
    TASER("Taser"),
    PISTOL("Pistola"),
    BLADE("Lâmina"),
    SNIPER("Sniper"),
    BAZOOKA("Bazuca"),
    DEPLETED_URANIUM_MUNITION("Munição de urânio empobrecido"),
    BOMB("Bomba");
    private String nome;

    PoderioBelico(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public PoderioBelico getByEnum(String localEnum) {
        try {
            return PoderioBelico.valueOf(localEnum.toUpperCase(Locale.ROOT));
        } catch (Exception e) {
            return BOMB;
        }
    }
}
