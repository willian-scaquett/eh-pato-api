package com.ehpatho.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * A classe ValoresSelectDTO é responsável por disponibilizar o json com um valor de select
 * da tela de cadastro e edição de Nave
 *
 * @author Willian Scaquett willian.scaquett@gmail.com
 */
@Data
@AllArgsConstructor
public class ValoresSelectDTO {
    String value;
    String nome;
}
