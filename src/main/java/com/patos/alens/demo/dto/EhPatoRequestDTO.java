package com.patos.alens.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.patos.alens.demo.enumerated.LocalizacaoSuspeito;
import lombok.Data;

@JsonSerialize
@Data
public class EhPatoRequestDTO {

    int esverdeamento;
    int tamanhoBico;
    int grauSotaque;
    int recordeDiasSemComer;
    boolean temSmartphone;
    boolean gostaDeLagos;
    boolean comeOPaoDadoPelosVelhinhosNoParque;
    boolean cursaTI;
    String timeDoCoracao;
    LocalizacaoSuspeito localizacaoSuspeito;
    boolean emBando;
}
