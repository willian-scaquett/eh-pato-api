package com.patos.alens.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * A classe EhPatoResponseDTO por disponibilizar o json com a classificação do elemento suspeito
 * e a arma e abordagem recomenda pelo endpoint
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
