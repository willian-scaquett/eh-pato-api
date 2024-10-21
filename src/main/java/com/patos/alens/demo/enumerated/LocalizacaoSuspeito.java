package com.patos.alens.demo.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LocalizacaoSuspeito {
    AGUA("Água"),
    TERRA("Terra"),
    AR("Ar");

    private final String nome;

}
