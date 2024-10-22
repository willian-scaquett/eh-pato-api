package com.patos.alens.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonSerialize
@Data
@AllArgsConstructor
public class EhPatoResponseDTO {

    boolean ehPato;
    String armaRecomendada;
    String abordagemRecomendada;

}
