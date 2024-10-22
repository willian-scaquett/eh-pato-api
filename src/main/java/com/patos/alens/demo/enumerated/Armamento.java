package com.patos.alens.demo.enumerated;

import java.util.Locale;

/**
 * A classe PoderioBelico é responsável por disponibilizar o poder de armamento que uma nave tem
 *
 * @author Kaique Queiros kaique_q@outloom.com
 */
public enum Armamento {
    LASER("Laser"),
    CANHAO_LAVA("Canhão de lava"),
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

    Armamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public Armamento getByEnum(String localEnum) {
        try {
            return Armamento.valueOf(localEnum.toUpperCase(Locale.ROOT));
        } catch (Exception e) {
            return BOMB;
        }
    }
}
