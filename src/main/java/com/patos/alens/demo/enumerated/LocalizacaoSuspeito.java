package com.patos.alens.demo.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * O enumerador LocalizacaoSuspeito é responsável por disponibilizar o local onde está o elemento suspeito
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
