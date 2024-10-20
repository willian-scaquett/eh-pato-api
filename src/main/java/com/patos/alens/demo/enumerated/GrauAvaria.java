package com.patos.alens.demo.enumerated;

import java.util.Locale;

/**
 * O enumerador GrauAvaria é responsável por disponibilizar qual é o grau de avaria de uma nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
public enum GrauAvaria {
    PERDA_TOTAL("Perda Total", "Restam apenas pedaços flutuando no espaço. Definitivamente, não há volta."),

    MUITO_DESTRUIDA("Muito Destruída", "Ainda dá para reconhecer que era uma nave... mas é só isso."),

    PARCIALMENTE_DESTRUIDA("Parcialmente Destruída", "Danos sérios, mas algumas partes ainda funcionam. Talvez com muita fita adesiva..."),

    PRATICAMENTE_INTACTA("Praticamente Intacta", "Alguns arranhões aqui e ali, mas nada que impeça o voo."),

    SEM_AVARIAS("Sem Avarias", "Está como nova! Pode decolar para a próxima missão sem preocupações.");

    private final String nomeExibicao;
    private final String descricao;

    GrauAvaria(String nomeExibicao, String descricao) {
        this.nomeExibicao = nomeExibicao;
        this.descricao = descricao;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return nomeExibicao + " - " + descricao;
    }
    public GrauAvaria getByEnum(String localEnum) {
        try {
            return GrauAvaria.valueOf(localEnum.toUpperCase(Locale.ROOT));
        } catch (Exception e) {
            return SEM_AVARIAS;
        }
    }
}
