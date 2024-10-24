package com.ehpatho.api.dto;

import lombok.Data;

/**
 * A classe APIEhPatoIAResponseDTO é responsável por disponibilizar o json com a classificação do elemento suspeito
 * feita pela API da IA
 *
 * @author Willian Scaquett willian.scaquett@gmail.com
 */
@Data
public class APIEhPatoIAResponseDTO {

    boolean ehPato;
}
