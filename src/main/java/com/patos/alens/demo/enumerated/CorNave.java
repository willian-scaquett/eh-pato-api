package com.patos.alens.demo.enumerated;

import java.util.Locale;

/**
 * O enumerador CorNave é responsável por disponibilizar as possibildiades de cores para as naves
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
public enum CorNave {
    VERMELHA("Vermelha"),
    LARANJA("Laranja"),
    AMARELA("Amarela"),
    VERDE("Verde"),
    AZUL("Azul"),
    ANIL("Anil"),
    VIOLETA("Violeta"),
    COR_DESCONHECIDA("Cor desconhecida");

    private final String nome;

    CorNave(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public static CorNave getByEnum(String cor) {
        try {
            return CorNave.valueOf(cor.toUpperCase(Locale.ROOT));
        } catch (Exception e) {
            return COR_DESCONHECIDA;
        }
    }
}
