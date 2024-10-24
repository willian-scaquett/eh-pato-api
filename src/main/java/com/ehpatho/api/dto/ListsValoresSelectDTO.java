package com.ehpatho.api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe ListsValoresSelectDTO é responsável por disponibilizar o json com os valores dos selects
 * da tela de cadastro e edição de Nave
 *
 * @author Willian Scaquett willian.scaquett@gmail.com
 */
@Data
public class ListsValoresSelectDTO {
    List<ValoresSelectDTO> cores = new ArrayList<>();
    List<ValoresSelectDTO> locais = new ArrayList<>();
    List<ValoresSelectDTO> combustiveis = new ArrayList<>();
    List<ValoresSelectDTO> graus = new ArrayList<>();
    List<ValoresSelectDTO> potenciais = new ArrayList<>();
    List<ValoresSelectDTO> armamentos = new ArrayList<>();
    List<ValoresSelectDTO> tamanhos = new ArrayList<>();
}
