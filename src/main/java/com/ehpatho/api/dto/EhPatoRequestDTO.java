package com.ehpatho.api.dto;

import com.ehpatho.api.enumerated.LocalizacaoSuspeito;
import lombok.Data;

/**
 * A classe EhPatoRequestDTO é responsável por representar o que corpo da requisição feita à api para
 * identificar o elemento suspeito e escolher a arma e a abordagem recomendada
 *
 * @author Willian Scaquett willian.scaquett@gmail.com
 */
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
