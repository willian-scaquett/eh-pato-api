package com.ehpatho.api.service;

import com.ehpatho.api.dto.APIEhPatoIAResponseDTO;
import com.ehpatho.api.dto.EhPatoRequestDTO;
import com.ehpatho.api.dto.EhPatoResponseDTO;
import com.ehpatho.api.enumerated.LocalizacaoSuspeito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class EhPatoServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private EhPatoService ehPatoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ehPatoService = new EhPatoService(restTemplate, "http://mock.teste");
    }

    @Test
    void testCriarEstrategia_EhPato() {
        APIEhPatoIAResponseDTO apiResponse = new APIEhPatoIAResponseDTO();
        apiResponse.setEhPato(true);

        when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), eq(APIEhPatoIAResponseDTO.class)))
                .thenReturn(ResponseEntity.ok(apiResponse));

        EhPatoRequestDTO request = new EhPatoRequestDTO();
        request.setEsverdeamento(3);
        request.setTamanhoBico(10);
        request.setGrauSotaque(3);
        request.setRecordeDiasSemComer(3);
        request.setTemSmartphone(false);
        request.setGostaDeLagos(true);
        request.setComeOPaoDadoPelosVelhinhosNoParque(true);
        request.setCursaTI(false);
        request.setTimeDoCoracao("Patomeiras");

        EhPatoResponseDTO response = ehPatoService.criarEstrategia(request);

        assertTrue(response.isEhPato());
        assertNull(response.getArmaRecomendada());
        assertNull(response.getAbordagemRecomendada());
    }

    @Test
    void testCriarEstrategia_NaoEhPato_EmBandoTerra() {
        APIEhPatoIAResponseDTO apiResponse = new APIEhPatoIAResponseDTO();
        apiResponse.setEhPato(false);

        when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), eq(APIEhPatoIAResponseDTO.class)))
                .thenReturn(ResponseEntity.ok(apiResponse));

        EhPatoRequestDTO request = getEhPatoRequestDTO();

        request.setLocalizacaoSuspeito(LocalizacaoSuspeito.TERRA);
        request.setEmBando(true);

        EhPatoResponseDTO response = ehPatoService.criarEstrategia(request);

        assertFalse(response.isEhPato());
        assertEquals("Jaula gigante", response.getArmaRecomendada());
        assertEquals("Paciente", response.getAbordagemRecomendada());
    }

    @Test
    void testCriarEstrategia_NaoEhPato_SozinhoTerra() {
        APIEhPatoIAResponseDTO apiResponse = new APIEhPatoIAResponseDTO();
        apiResponse.setEhPato(false);

        when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), eq(APIEhPatoIAResponseDTO.class)))
                .thenReturn(ResponseEntity.ok(apiResponse));

        EhPatoRequestDTO request = getEhPatoRequestDTO();

        request.setLocalizacaoSuspeito(LocalizacaoSuspeito.TERRA);
        request.setEmBando(false);

        EhPatoResponseDTO response = ehPatoService.criarEstrategia(request);

        assertFalse(response.isEhPato());
        assertEquals("Taser", response.getArmaRecomendada());
        assertEquals("Paciente", response.getAbordagemRecomendada());
    }

    @Test
    void testCriarEstrategia_NaoEhPato_EmBandoAgua() {
        APIEhPatoIAResponseDTO apiResponse = new APIEhPatoIAResponseDTO();
        apiResponse.setEhPato(false);

        when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), eq(APIEhPatoIAResponseDTO.class)))
                .thenReturn(ResponseEntity.ok(apiResponse));

        EhPatoRequestDTO request = getEhPatoRequestDTO();

        request.setLocalizacaoSuspeito(LocalizacaoSuspeito.AGUA);
        request.setEmBando(true);

        EhPatoResponseDTO response = ehPatoService.criarEstrategia(request);

        assertFalse(response.isEhPato());
        assertEquals("Rede de pesca de adamantium", response.getArmaRecomendada());
        assertEquals("Furtivo", response.getAbordagemRecomendada());
    }

    @Test
    void testCriarEstrategia_NaoEhPato_SozinhoAgua() {
        APIEhPatoIAResponseDTO apiResponse = new APIEhPatoIAResponseDTO();
        apiResponse.setEhPato(false);

        when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), eq(APIEhPatoIAResponseDTO.class)))
                .thenReturn(ResponseEntity.ok(apiResponse));

        EhPatoRequestDTO request = getEhPatoRequestDTO();

        request.setLocalizacaoSuspeito(LocalizacaoSuspeito.AGUA);
        request.setEmBando(false);

        EhPatoResponseDTO response = ehPatoService.criarEstrategia(request);

        assertFalse(response.isEhPato());
        assertEquals("Congelador instantâneo", response.getArmaRecomendada());
        assertEquals("Enérgico", response.getAbordagemRecomendada());
    }

    @Test
    void testCriarEstrategia_NaoEhPato_EmBandoAr() {
        APIEhPatoIAResponseDTO apiResponse = new APIEhPatoIAResponseDTO();
        apiResponse.setEhPato(false);

        when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), eq(APIEhPatoIAResponseDTO.class)))
                .thenReturn(ResponseEntity.ok(apiResponse));

        EhPatoRequestDTO request = getEhPatoRequestDTO();

        request.setLocalizacaoSuspeito(LocalizacaoSuspeito.AR);
        request.setEmBando(true);

        EhPatoResponseDTO response = ehPatoService.criarEstrategia(request);

        assertFalse(response.isEhPato());
        assertEquals("Aspirador de pó nuclear", response.getArmaRecomendada());
        assertEquals("Enérgico", response.getAbordagemRecomendada());
    }

    @Test
    void testCriarEstrategia_NaoEhPato_SozinhoAr() {
        APIEhPatoIAResponseDTO apiResponse = new APIEhPatoIAResponseDTO();
        apiResponse.setEhPato(false);

        when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), eq(APIEhPatoIAResponseDTO.class)))
                .thenReturn(ResponseEntity.ok(apiResponse));

        EhPatoRequestDTO request = getEhPatoRequestDTO();

        request.setLocalizacaoSuspeito(LocalizacaoSuspeito.AR);
        request.setEmBando(false);

        EhPatoResponseDTO response = ehPatoService.criarEstrategia(request);

        assertFalse(response.isEhPato());
        assertEquals("Laço teleguiado", response.getArmaRecomendada());
        assertEquals("Furtivo", response.getAbordagemRecomendada());
    }

    @Test
    void testCriarEstrategia_ApiErro() {
        when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), eq(APIEhPatoIAResponseDTO.class)))
                .thenThrow(new RuntimeException("Erro na API"));

        EhPatoRequestDTO request = getEhPatoRequestDTO();

        assertThrows(RuntimeException.class, () -> ehPatoService.criarEstrategia(request));

        verify(restTemplate, times(1)).exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), eq(APIEhPatoIAResponseDTO.class));
    }

    private static EhPatoRequestDTO getEhPatoRequestDTO() {
        EhPatoRequestDTO request = new EhPatoRequestDTO();
        request.setEsverdeamento(10);
        request.setTamanhoBico(1);
        request.setGrauSotaque(10);
        request.setRecordeDiasSemComer(70);
        request.setTemSmartphone(true);
        request.setGostaDeLagos(false);
        request.setComeOPaoDadoPelosVelhinhosNoParque(false);
        request.setCursaTI(true);
        request.setTimeDoCoracao("Patorinthians");

        return request;
    }
}
