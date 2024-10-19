package com.patos.alens.demo.enumerated;

/**
 * A classe TipoCombustivel é responsável por representar o tipo de combustivel de uma nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
public enum TipoCombustivel {

    PLASMA_DE_PLUTONIO("Plasma de Plutônio", "Energia nuclear instável, mas eficiente. Só não chegue muito perto."),

    GOTAS_DE_MATERIA_ESCURA("Gotas de Matéria Escura", "Aquela coisa misteriosa que ninguém entende, mas todo mundo jura que funciona."),

    LAGRIMAS_DE_UNICORNIO("Lágrimas de Unicórnio", "Raro, caríssimo e possivelmente devastador... mas dizem que vale o investimento!"),

    ESPRESSO_QUANTICO("Espresso Quântico", "Para naves que precisam de um impulso rápido. Funciona melhor que café."),

    FALHA_GRAVITACIONAL("Falha Gravitacional", "Explora falhas na gravidade. Incrivelmente instável, mas muito divertido."),

    PARTICULAS_VIRTUAIS("Partículas Virtuais", "Combustível que existe e não existe ao mesmo tempo. Esperamos que funcione...");

    private final String nome;
    private final String descricao;

    TipoCombustivel(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return nome + " - " + descricao;
    }
}
