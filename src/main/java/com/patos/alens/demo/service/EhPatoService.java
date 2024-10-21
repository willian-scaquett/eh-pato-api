package com.patos.alens.demo.service;

import com.patos.alens.demo.dto.APIEhPatoResponseDTO;
import com.patos.alens.demo.dto.EhPatoRequestDTO;
import com.patos.alens.demo.dto.EhPatoResponseDTO;
import com.patos.alens.demo.enumerated.LocalizacaoSuspeito;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class EhPatoService {

    private final RestTemplate restTemplate;

    public EhPatoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EhPatoResponseDTO criarEstrategia(EhPatoRequestDTO ehPatoResquestDTO) {
        String apiUrl = "http://127.0.0.1:8000/verificarElemento";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        Map<String, Object> body = new HashMap<>();

        body.put("esverdeamento", ehPatoResquestDTO.getEsverdeamento());
        body.put("tamanho_bico", ehPatoResquestDTO.getTamanhoBico());
        body.put("grau_sotaque", ehPatoResquestDTO.getGrauSotaque());
        body.put("recorde_dias_sem_comer", ehPatoResquestDTO.getRecordeDiasSemComer());
        body.put("tem_smartphone", ehPatoResquestDTO.isTemSmartphone() ? "Sim" : "Não");
        body.put("gosta_de_lagos", ehPatoResquestDTO.isGostaDeLagos() ? "Sim" : "Não");
        body.put("come_o_pao_dado_pelos_velhinhos_no_parque", ehPatoResquestDTO.isComeOPaoDadoPelosVelhinhosNoParque() ? "Sim" : "Não");
        body.put("cursa_ti", ehPatoResquestDTO.isCursaTI() ? "Sim" : "Não");
        body.put("time_do_coracao", ehPatoResquestDTO.getTimeDoCoracao());

        HttpEntity<String> requestEntity = new HttpEntity(body, headers);

        ResponseEntity<APIEhPatoResponseDTO> responseAPI = restTemplate.exchange(apiUrl, HttpMethod.PUT, requestEntity, APIEhPatoResponseDTO.class);

        EhPatoResponseDTO response = new EhPatoResponseDTO();

        if (responseAPI.getBody().isEhPato()) {
            response.setEhPato(true);
            response.setArmaRecomendada("");

            return response;
        }

        response.setEhPato(false);
        response.setArmaRecomendada(escolherArma(ehPatoResquestDTO.getLocalizacaoSuspeito(), ehPatoResquestDTO.isEmBando()));

        return response;
    }

    private String escolherArma(LocalizacaoSuspeito localizacaoSuspeito, boolean emBando) {
        if (emBando) {
            if (localizacaoSuspeito.equals(LocalizacaoSuspeito.AR)) {
                return "Aspirador de pó nuclear"; //Aponte para o ar e sugue os aliens direto para a prisão
            } else if (localizacaoSuspeito.equals(LocalizacaoSuspeito.AGUA)) {
                return "Rede de pesca de adamantium"; //Lance-a e certifique-se de acertar todos eles
            } else if (localizacaoSuspeito.equals(LocalizacaoSuspeito.TERRA)) {
                return "Jaula gigante"; //Apenas uma boa e velha jaula mesmo. Simples e eficaz.
            }
        } else {
            if (localizacaoSuspeito.equals(LocalizacaoSuspeito.AR)) {
                return "Laço teleguiado"; //Segure firme, pois ele vai tentar fugir
            } else if (localizacaoSuspeito.equals(LocalizacaoSuspeito.AGUA)) {
                return "Congelador instantâneo"; //Congele a água onde o alien está e prenda-o assim mesmo
            } else if (localizacaoSuspeito.equals(LocalizacaoSuspeito.TERRA)) {
                return "Taser"; //Assim como a jaula, apenas um taser mesmo. O alien ficará paralisado pela surpresa (ou pelo choque).
            }
        }
        return "";
    }
}
