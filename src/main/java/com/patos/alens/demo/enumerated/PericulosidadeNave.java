package com.patos.alens.demo.enumerated;

/**
 * O enumerador PericulosidadeNave é responsável por representar o grau de periculosidade de uma nave ao se aproximar dela
 * @author Kaique Queiros kaique_q@outlook.com
 */
public enum PericulosidadeNave {

    SEGURO("Seguro", "Nenhuma ameaça detectada. A nave parece pacífica e não exibe sinais de hostilidade. Comunicação diplomática recomendada."),

    CAUTELA("Cautela", "Leves sinais de atividade incomum, mas sem comportamentos agressivos. Aproximação com precaução é aconselhada."),

    AMEAÇA_POTENCIAL("Ameaça Potencial", "A nave exibe capacidades tecnológicas avançadas e posturas defensivas. Aproximação com extremo cuidado, prontidão para evacuação ou combate."),

    AMEAÇA_IMINENTE("Ameaça Iminente", "A nave exibe comportamentos hostis ou ações ofensivas. Sua presença indica perigo imediato. Prepare-se para evasão ou combate."),

    EXTINCAO_ASSEGURADA("Extinção Assegurada", "Nível de ameaça máxima. A presença da nave significa destruição total garantida. A sobrevivência é altamente improvável.");

    private final String nomeExibicao;
    private final String descricao;

    PericulosidadeNave(String nomeExibicao, String descricao) {
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
