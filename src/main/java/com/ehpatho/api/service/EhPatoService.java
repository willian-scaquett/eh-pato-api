package com.ehpatho.api.service;

import com.ehpatho.api.dto.APIEhPatoIAResponseDTO;
import com.ehpatho.api.dto.EhPatoRequestDTO;
import com.ehpatho.api.dto.EhPatoResponseDTO;
import com.ehpatho.api.enumerated.LocalizacaoSuspeito;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

/**
 * A classe EhPatoService é responsável por disponibilizar a regra de negócio da verificação de elemento suspeito
 * e elaboração de arma e estratégia
 *
 * @author Willian Scaquett willian.scaquett@gmail.com
 */
@Slf4j
@Service
public class EhPatoService {

    private final RestTemplate restTemplate; //Classe que realiza a comunicação entre as APIs

    @Value("${api.ia.url}")
    private String apiIaUrl; //URL da API Python que consulta a IA

    public EhPatoService(RestTemplate restTemplate, @Value("${api.ia.url}") String apiIaUrl) {
        this.restTemplate = restTemplate;
        this.apiIaUrl = apiIaUrl;
    }

    public EhPatoResponseDTO criarEstrategia(EhPatoRequestDTO ehPatoResquestDTO) {
        //Consulta a API Python com a IA que verifica se o elemento suspeito é alien ou pato
        if (verificarEhPato(ehPatoResquestDTO).isEhPato()) {
            //Avisa que é pato e não recomenda arma nem abordagem
            log.info("Elemento suspeito identificado como Pato. Nenhuma ação necessária.");
            return new EhPatoResponseDTO(true, null, null);
        }

        //Avisa que é alien e recomenda uma arma e uma abordagem conforme a localização e se o elemento está em bando
        log.info("Elemento suspeito identificado como Alien. Preparando estratégia.");
        return escolherArmaEAbordagem(ehPatoResquestDTO.getLocalizacaoSuspeito(), ehPatoResquestDTO.isEmBando());
    }

    private EhPatoResponseDTO escolherArmaEAbordagem(LocalizacaoSuspeito localizacaoSuspeito, boolean emBando) {
        String arma = "";
        String abordagem = "";

        if (emBando) {
            if (localizacaoSuspeito.equals(LocalizacaoSuspeito.AR)) {
                arma = "Aspirador de pó nuclear"; //Aponte para o ar e sugue os aliens direto para a prisão
                abordagem = "Enérgico"; //Para que nenhum fuja!
            } else if (localizacaoSuspeito.equals(LocalizacaoSuspeito.AGUA)) {
                arma = "Rede de pesca de adamantium"; //Lance-a e certifique-se de acertar todos eles
                abordagem = "Furtivo"; //Eles são melhores que nós na água e estão em maior número
            } else if (localizacaoSuspeito.equals(LocalizacaoSuspeito.TERRA)) {
                arma = "Jaula gigante"; //Apenas uma boa e velha jaula mesmo. Simples e eficaz.
                abordagem = "Paciente"; //Espere eles estarem bem juntos e cuidado para não fazer barulho
            }
        } else {
            if (localizacaoSuspeito.equals(LocalizacaoSuspeito.AR)) {
                arma = "Laço teleguiado"; //Segure firme, pois ele vai tentar fugir
                abordagem = "Furtivo"; //Ele só pode ver o laço quando for atingido
            } else if (localizacaoSuspeito.equals(LocalizacaoSuspeito.AGUA)) {
                arma = "Congelador instantâneo"; //Congele a água onde o alien está e prenda-o assim mesmo
                abordagem = "Enérgico"; //Se deixar ele nadar, você nunca mais o alcançará
            } else if (localizacaoSuspeito.equals(LocalizacaoSuspeito.TERRA)) {
                arma = "Taser"; //Assim como a jaula, apenas um taser mesmo. O alien ficará paralisado pela surpresa (ou pelo choque).
                abordagem = "Paciente"; //Tenha calma e mire bem
            }
        }

        log.info("Arma escolhida: {}. Abordagem escolhida: {}.", arma, abordagem);
        return new EhPatoResponseDTO(false, arma, abordagem);
    }

    private APIEhPatoIAResponseDTO verificarEhPato(EhPatoRequestDTO ehPatoResquestDTO) {
        HttpHeaders headers = new HttpHeaders(); //Cria os headers da requisição
        headers.set("Content-Type", "application/json");

        HttpEntity<Map<String, Object>> requestEntity = getRequestEntity(ehPatoResquestDTO, headers);

        //Dispara requisição
        log.info("Enviando requisição para verificar se é pato...");
        ResponseEntity<APIEhPatoIAResponseDTO> response;
        try {
            response = restTemplate.exchange(apiIaUrl, HttpMethod.POST, requestEntity, APIEhPatoIAResponseDTO.class);
            log.info("Resposta recebida da API IA: {}", response.getBody());
        } catch (Exception e) {
            log.error("Falha de comunicação com a API da IA", e);
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Falha de comunicação com a API da IA");
        }

        //Retorna o body recebido
        return response.getBody();
    }

    private static HttpEntity<Map<String, Object>> getRequestEntity(EhPatoRequestDTO ehPatoResquestDTO, HttpHeaders headers) {
        Map<String, Object> body = new HashMap<>();

        //Cria o body da requisição convertendo os campos para os nomes e formatos esperados pela API Python
        body.put("esverdeamento", ehPatoResquestDTO.getEsverdeamento());
        body.put("tamanho_bico", ehPatoResquestDTO.getTamanhoBico());
        body.put("grau_sotaque", ehPatoResquestDTO.getGrauSotaque());
        body.put("recorde_dias_sem_comer", ehPatoResquestDTO.getRecordeDiasSemComer());
        body.put("tem_smartphone", ehPatoResquestDTO.isTemSmartphone() ? "Sim" : "Não");
        body.put("gosta_de_lagos", ehPatoResquestDTO.isGostaDeLagos() ? "Sim" : "Não");
        body.put("come_o_pao_dado_pelos_velhinhos_no_parque", ehPatoResquestDTO.isComeOPaoDadoPelosVelhinhosNoParque() ? "Sim" : "Não");
        body.put("cursa_ti", ehPatoResquestDTO.isCursaTI() ? "Sim" : "Não");
        body.put("time_do_coracao", ehPatoResquestDTO.getTimeDoCoracao());

        return new HttpEntity<>(body, headers);
    }
}
