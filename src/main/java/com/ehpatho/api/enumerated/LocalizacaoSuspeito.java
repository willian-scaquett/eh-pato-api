package com.ehpatho.api.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * O enumerador LocalizacaoSuspeito é responsável por disponibilizar o local onde o elemento suspeito pode estar
 *
 * @author Willian Scaquett willian.scaquett@gmail.com
 */
@AllArgsConstructor
@Getter
public enum LocalizacaoSuspeito {
    AGUA("Água"),
    TERRA("Terra"),
    AR("Ar");

    private final String nome;
}
