package com.patos.alens.demo.enumerated;

import java.util.Locale;

/**
 * A classe TamanhoNave é responsável por representar o tamanho de uma nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
public enum Tamanho {
    PEQUENA("Pequena"),
    MEDIA("Média"),
    GRANDE("Grande"),
    COLOSSAL("Colossal"),
    TAMANHO_DESCONHECIDO("Tamanho desconhecido");

    private final String nome;

    Tamanho(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public Tamanho getByEnum(String tamanho) {
        try {
            return Tamanho.valueOf(tamanho.toUpperCase(Locale.ROOT));
        } catch (Exception e) {
            return TAMANHO_DESCONHECIDO;
        }
    }
}
