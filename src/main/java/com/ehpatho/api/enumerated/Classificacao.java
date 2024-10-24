package com.ehpatho.api.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * O enumerador Classificacao é responsável por disponibilizar as classificações que uma nave pode receber
 *
 * @author Willian Scaquett willian.scaquett@gmail.com
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
