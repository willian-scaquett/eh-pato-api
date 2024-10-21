package com.patos.alens.demo.enumerated;

/**
 * A classe EstadoTripulante é responsavel por disponibilizar o estado em que um tripulante de encontra
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
public enum EstadoTripulante {
    BEM("Está bem", "Não sofreu nada com a queda"),
    FERIDO("Está ferido", "Sofreu alguns ferimentos na queda"),
    FOI_COM_DEUS("Foi com Deus", "Não suportou a queda e hoje está nos braços do criador. F");

    private final String nomeExibicao;
    private final String descricao;

    EstadoTripulante(String nomeExibicao, String descricao) {
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
