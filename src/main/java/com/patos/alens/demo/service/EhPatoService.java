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

    private final RestTemplate restTemplate; //Classe que realiza a comunicação entre as APIs
    private final String API_IA_URL = "http://0.0.0.0:8000/verificarElemento"; //URL da API Python que consulta a IA

    public EhPatoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EhPatoResponseDTO criarEstrategia(EhPatoRequestDTO ehPatoResquestDTO) {
        //Consulta a API Python com a IA que verifica se o elemento suspeito é alien ou pato
        if (verificarEhPato(ehPatoResquestDTO).isEhPato()) {
            //Avisa que é pato e não recomenda arma nem abordagem
            return new EhPatoResponseDTO(true, null, null);
        }

        //Avisa que é alien e recomenda uma arma e uma abordagem conforme a localização e se o elemento está em bando
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

        return new EhPatoResponseDTO(false, arma, abordagem);
    }

    private APIEhPatoResponseDTO verificarEhPato(EhPatoRequestDTO ehPatoResquestDTO) {
        HttpHeaders headers = new HttpHeaders(); //Cria os headers da requisição
        headers.set("Content-Type", "application/json");

        //Cria o body da requisição convertendo os campos para os nomes e formatos esperados pela API Python
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

        //Dispara requisição
        ResponseEntity<APIEhPatoResponseDTO> response = restTemplate.exchange(API_IA_URL, HttpMethod.PUT, requestEntity, APIEhPatoResponseDTO.class);

        //Retorna o body recebido
        return response.getBody();
    }
}
