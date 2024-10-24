package com.patos.alens.demo.dto;

import lombok.Data;

/**
 * A classe APIEhPatoResponseDTO é responsável por disponibilizar o json com a classificação do elemento suspeito
 * feita pela API da IA
 *
 * @author Willian Scaquett willian.scaquett@gmail.com
 */
@Data
public class APIEhPatoResponseDTO {

    boolean ehPato;
}
