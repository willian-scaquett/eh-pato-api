package com.patos.alens.demo.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * O enumerador Periculosidade é responsável por representar o grau de periculosidade de uma nave ao se aproximar dela
 * @author Kaique Queiros kaique_q@outlook.com
 */
@Getter
@AllArgsConstructor
public enum Classificacao {
    SUCATA_ESPACIAL("Sucata Espacial"),
    AMEACA_EM_POTENCIAL("Ameaça em Potencial"),
    FONTE_DE_ENERGIA("Fonte de Energia Alternativa"),
    ARSENAL_ALIENIGENA("Arsenal Alienígena"),
    JOIA_TECNOLOGICA("Joia Tecnológica");

    private final String nome;
}
