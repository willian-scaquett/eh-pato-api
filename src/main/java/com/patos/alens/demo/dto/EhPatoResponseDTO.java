package com.patos.alens.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
public class EhPatoResponseDTO {

    boolean ehPato;
    String armaRecomendada;

}
