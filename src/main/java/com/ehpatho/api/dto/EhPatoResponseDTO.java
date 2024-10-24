package com.ehpatho.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * A classe EhPatoResponseDTO é responsável por disponibilizar o json com a classificação do elemento suspeito
 * e a arma e a abordagem recomendadas pelo endpoint
 *
 * @author Willian Scaquett willian.scaquett@gmail.com
 */
@Data
@AllArgsConstructor
public class EhPatoResponseDTO {

    boolean ehPato;
    String armaRecomendada;
    String abordagemRecomendada;
}
