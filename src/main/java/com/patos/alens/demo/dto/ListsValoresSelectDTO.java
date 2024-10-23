package com.patos.alens.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ListsValoresSelectDTO {
    List<ValoresSelectDTO> cores = new ArrayList<>();
    List<ValoresSelectDTO> locais = new ArrayList<>();
    List<ValoresSelectDTO> combustiveis = new ArrayList<>();
    List<ValoresSelectDTO> graus = new ArrayList<>();
    List<ValoresSelectDTO> potenciais = new ArrayList<>();
    List<ValoresSelectDTO> armamentos = new ArrayList<>();
}
