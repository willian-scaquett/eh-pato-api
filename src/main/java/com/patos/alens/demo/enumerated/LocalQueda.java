package com.patos.alens.demo.enumerated;

import java.util.Locale;

/**
 * A classe LocalQueda é responsável por disponibilizar onde a máquina caiu
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
public enum LocalQueda {
    OCEANO("Oceano"),
    CONTINENTE("Continente"),
    SO_DEUS_SABE("Só Deus Sabe");

    private final String nome;

    LocalQueda(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public LocalQueda getByEnum(String localEnum) {
        try {
            return LocalQueda.valueOf(localEnum.toUpperCase(Locale.ROOT));
        } catch (Exception e) {
            return SO_DEUS_SABE;
        }
    }
}
