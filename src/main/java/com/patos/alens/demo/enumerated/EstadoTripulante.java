package com.patos.alens.demo.enumerated;

/**
 * A classe EstadoTripulante é responsavel por disponibilizar o estado em que um tripulante de encontra
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
public enum EstadoTripulante {
    INTACTO("Intacto", "Milagrosamente sem um arranhão. Deve ter rolado uma bênção alienígena."),
    ARRANHAO_AQUI_E_ALI("Arranhão Aqui e Ali", "Nada muito grave, só algumas marcas de batalha para contar história."),
    MAIS_OU_MENOS("Mais ou Menos", "Meio tonto, meio dolorido, mas ainda de pé... ou quase."),
    RESPIRANDO_POR_APARELHOS("Respirando por Aparelhos", "Só mantendo o básico. Talvez seja hora de chamar ajuda."),
    FRATURADO("Fraturado", "Um osso aqui, outro ali... mas nada que a tecnologia espacial não possa resolver."),
    DESMAIADO("Desmaiado", "Caiu junto com a nave e ainda não acordou. Deve estar em outro planeta... de sonhos."),
    CAMINHANDO_QUE_NEM_ZUMBI("Caminhando que Nem Zumbi", "Está de pé, mas parece mais uma versão espacial de 'The Walking Dead'."),
    EM_ESTADO_CRITICO("Em Estado Crítico", "Já ligaram o alarme médico e as sirenes. Está por um fio!"),
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
