package com.patos.alens.demo.enumerated;

/**
 * O enumerador PotencialTecnologico é responsável por representar qual o potencial tecnologico de uma nave
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
public enum PotencialTecnologico {
    PRIMITIVA("Primitiva", "Tecnologia rudimentar e arcaica, baseada em princípios básicos de propulsão e energia."),

    AVANCADA("Avançada", "Tecnologia avançada com capacidades de viagem interestelar. Sistemas de armas e defesas eficientes."),

    SOBERANA("Soberana", "Nível tecnológico de uma civilização dominante no espaço, com domínio sobre buracos de minhoca, energia antimatéria e inteligência artificial autoconsciente."),

    DIVINA("Divina", "Tecnologia incompreensível e além da imaginação, possivelmente confundida com magia. Capaz de manipular a estrutura do espaço-tempo, modificar a realidade e até mesmo desafiar as leis da física."),

    TRANSCENDENTE("Transcendente", "Alcançou um nível tecnológico que vai além do plano físico. A nave é uma manifestação de energia pura, existindo simultaneamente em várias dimensões e realidades.");

    private final String nomeExibicao;
    private final String descricao;

    PotencialTecnologico(String nomeExibicao, String descricao) {
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
}
