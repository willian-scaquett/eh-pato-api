package com.ehpatho.api.service;

import com.ehpatho.api.dto.ListsValoresSelectDTO;
import com.ehpatho.api.dto.NaveRequestDTO;
import com.ehpatho.api.dto.NaveResponseDTO;
import com.ehpatho.api.entity.Nave;
import com.ehpatho.api.enumerated.*;
import com.ehpatho.api.repository.NaveRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * A classe NaveServiceTest é responsável por realizar testes unitários da classe NaveService
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@SpringBootTest
@AutoConfigureMockMvc
public class NaveServiceTest {
    @MockBean
    private NaveService naveService;
    @Mock
    private NaveRepository naveRepository;
    @MockBean
    private NaveClassificador naveClassificador;

    @BeforeEach
    public void init() {
        naveService = new NaveService(naveRepository, naveClassificador);
    }

    @Test
    public void testaBuscarTodasAsNaves() {
        List<NaveResponseDTO> naveResponseDTOList = naveService.listaNaves();
        Assertions.assertEquals(0, naveResponseDTOList.size());
    }

    @Test
    public void testaCriarNovaNave_Success() {
        Nave nave = new Nave(getRequestDTO());
        nave.setId(1L);
        nave.setPericulosidade(Periculosidade.ALTA);
        nave.setClassificacao(Classificacao.AMEACA_EM_POTENCIAL);
        when(naveRepository.save(any(Nave.class))).thenReturn(nave);
        when(naveClassificador.definirCategoriaEPericulosidade(any(Nave.class))).thenReturn(nave);
        NaveResponseDTO naveResponseDTO = naveService.criarNave(getRequestDTO());

        Assertions.assertEquals("Teste", naveResponseDTO.getNome());
        Assertions.assertEquals(Cor.AZUL.getNome(), naveResponseDTO.getCor());
    }

    @Test
    public void testaCriarNovaNave_NomeNull() {
        NaveRequestDTO naveRequestDTO = getRequestDTO();
        naveRequestDTO.setNome(null);
        Nave nave = new Nave(getRequestDTO());
        nave.setId(1L);
        nave.setPericulosidade(Periculosidade.ALTA);
        nave.setClassificacao(Classificacao.AMEACA_EM_POTENCIAL);
        when(naveRepository.save(any(Nave.class))).thenReturn(nave);
        when(naveClassificador.definirCategoriaEPericulosidade(any(Nave.class))).thenReturn(nave);

        assertThrows(ResponseStatusException.class, () -> {
            naveService.criarNave(naveRequestDTO);
        });
    }

    @Test
    public void testaCriarNovaNave_NomeVazio() {
        NaveRequestDTO naveRequestDTO = getRequestDTO();
        naveRequestDTO.setNome("");
        Nave nave = new Nave(getRequestDTO());
        nave.setId(1L);
        nave.setPericulosidade(Periculosidade.ALTA);
        nave.setClassificacao(Classificacao.AMEACA_EM_POTENCIAL);
        when(naveRepository.save(any(Nave.class))).thenReturn(nave);
        when(naveClassificador.definirCategoriaEPericulosidade(any(Nave.class))).thenReturn(nave);

        assertThrows(ResponseStatusException.class, () -> {
            naveService.criarNave(naveRequestDTO);
        });
    }


    @Test
    public void testaCriarNaveComNomeExistente() {
        when(this.naveRepository.existsByNome(anyString())).thenReturn(true);
        NaveRequestDTO naveRequestDTO = new NaveRequestDTO();
        naveRequestDTO.setNome("Nave Fênix");
        naveRequestDTO.setCor(Cor.AZUL);
        naveRequestDTO.setTotalTripulanteBem(10);
        naveRequestDTO.setGrauAvaria(GrauAvaria.SEM_AVARIAS);
        naveRequestDTO.setPotencialTecnologico(PotencialTecnologico.AVANCADA);
        naveRequestDTO.setTipoCombustivel(TipoCombustivel.ESPRESSO_QUANTICO);
        naveRequestDTO.setTotalTripulanteFerido(10);
        naveRequestDTO.setTotalTripulanteFoiComDeus(40);

        assertThrows(ResponseStatusException.class, () -> {
            naveService.criarNave(naveRequestDTO);
        });
    }

    @Test
    public void testaApagarNave() {
        Nave nave = new Nave();
        nave.setId(1L);
        when(this.naveRepository.findById(1L)).thenReturn(Optional.of(nave));
        doNothing().when(this.naveRepository).delete(nave);

        this.naveService.apagarNave(1L);

        verify(naveRepository).delete(nave);
    }

    @Test
    public void testaApagarNaveNaveNãoEncontrada() {
        Nave nave = new Nave();
        nave.setId(1L);
        when(this.naveRepository.findById(2L)).thenReturn(Optional.of(nave));
        doNothing().when(this.naveRepository).delete(nave);

        assertThrows(ResponseStatusException.class, () -> {
            naveService.apagarNave(anyLong());
        });
    }

    @Test
    public void testaEditarNave() {

        Nave naveSemEditar = new Nave(getRequestDTO());
        naveSemEditar.setId(1L);
        naveSemEditar.setPericulosidade(Periculosidade.ALTA);
        naveSemEditar.setClassificacao(Classificacao.AMEACA_EM_POTENCIAL);

        NaveRequestDTO atualizado = getRequestDTO();

        //Atualizando nome e tipo de combustivel
        atualizado.setNome("Teste atualizado");
        atualizado.setTipoCombustivel(TipoCombustivel.PLUTONIO);

        Nave nave = new Nave(atualizado);
        nave.setId(1L);
        nave.setNome("Teste atualizado");
        nave.setPericulosidade(Periculosidade.ALTA);
        nave.setClassificacao(Classificacao.AMEACA_EM_POTENCIAL);

        when(this.naveRepository.findById(1L)).thenReturn(Optional.of(naveSemEditar));
        when(this.naveClassificador.definirCategoriaEPericulosidade(any(Nave.class))).thenReturn(nave);
        when(this.naveRepository.save(any(Nave.class))).thenReturn(nave);

        NaveResponseDTO responseDTO = this.naveService.editarNave(1L, atualizado);

        assertEquals("Teste atualizado", responseDTO.getNome());
        assertEquals("Plutônio", responseDTO.getTipoCombustivel());

    }

    @Test
    public void testaEditarNave_NomeNull() {

        Nave naveSemEditar = new Nave(getRequestDTO());
        naveSemEditar.setId(1L);
        naveSemEditar.setPericulosidade(Periculosidade.ALTA);
        naveSemEditar.setClassificacao(Classificacao.AMEACA_EM_POTENCIAL);

        NaveRequestDTO atualizado = getRequestDTO();

        atualizado.setNome(null);
        atualizado.setTipoCombustivel(TipoCombustivel.PLUTONIO);

        Nave nave = new Nave(atualizado);
        nave.setId(1L);
        nave.setPericulosidade(Periculosidade.ALTA);
        nave.setClassificacao(Classificacao.AMEACA_EM_POTENCIAL);

        when(this.naveRepository.findById(1L)).thenReturn(Optional.of(naveSemEditar));
        when(this.naveClassificador.definirCategoriaEPericulosidade(any(Nave.class))).thenReturn(nave);
        when(this.naveRepository.save(any(Nave.class))).thenReturn(nave);

        assertThrows(ResponseStatusException.class, () -> {
            naveService.criarNave(atualizado);
        });

    }

    @Test
    public void testaEditarNave_NomeVazio() {

        Nave naveSemEditar = new Nave(getRequestDTO());
        naveSemEditar.setId(1L);
        naveSemEditar.setPericulosidade(Periculosidade.ALTA);
        naveSemEditar.setClassificacao(Classificacao.AMEACA_EM_POTENCIAL);

        NaveRequestDTO atualizado = getRequestDTO();

        atualizado.setNome("");
        atualizado.setTipoCombustivel(TipoCombustivel.PLUTONIO);

        Nave nave = new Nave(atualizado);
        nave.setId(1L);
        nave.setPericulosidade(Periculosidade.ALTA);
        nave.setClassificacao(Classificacao.AMEACA_EM_POTENCIAL);

        when(this.naveRepository.findById(1L)).thenReturn(Optional.of(naveSemEditar));
        when(this.naveClassificador.definirCategoriaEPericulosidade(any(Nave.class))).thenReturn(nave);
        when(this.naveRepository.save(any(Nave.class))).thenReturn(nave);

        assertThrows(ResponseStatusException.class, () -> {
            naveService.criarNave(atualizado);
        });

    }

    @Test
    public void testaEditarNave_NomeExistenteIdNulo() {

        Nave naveSemEditar = new Nave(getRequestDTO());
        naveSemEditar.setId(1L);
        naveSemEditar.setPericulosidade(Periculosidade.ALTA);
        naveSemEditar.setClassificacao(Classificacao.AMEACA_EM_POTENCIAL);

        NaveRequestDTO atualizado = getRequestDTO();

        atualizado.setNome("Teste");
        atualizado.setTipoCombustivel(TipoCombustivel.PLUTONIO);

        Nave nave = new Nave(atualizado);
        nave.setId(1L);
        nave.setPericulosidade(Periculosidade.ALTA);
        nave.setClassificacao(Classificacao.AMEACA_EM_POTENCIAL);

        when(this.naveRepository.findById(1L)).thenReturn(Optional.of(naveSemEditar));
        when(this.naveClassificador.definirCategoriaEPericulosidade(any(Nave.class))).thenReturn(nave);
        when(this.naveRepository.save(any(Nave.class))).thenReturn(nave);
        when(this.naveRepository.existsByNomeAndIdNot(anyString(), anyLong())).thenReturn(true);

        assertThrows(ResponseStatusException.class, () -> {
            naveService.editarNave(nave.getId(), atualizado);
        });

    }

    @Test
    public void testaGetValoresSelectsCadastro() {

        ListsValoresSelectDTO listsValoresSelectDTO = this.naveService.getValoresSelectsCadastro();

        Assertions.assertEquals(6, listsValoresSelectDTO.getArmamentos().size());
        Assertions.assertEquals(7, listsValoresSelectDTO.getCores().size());
        Assertions.assertEquals(6, listsValoresSelectDTO.getCombustiveis().size());
        Assertions.assertEquals(5, listsValoresSelectDTO.getPotenciais().size());
        Assertions.assertEquals(4, listsValoresSelectDTO.getTamanhos().size());
        Assertions.assertEquals(5, listsValoresSelectDTO.getGraus().size());
    }

    public NaveRequestDTO getRequestDTO() {
        NaveRequestDTO naveRequestDTO = new NaveRequestDTO();
        naveRequestDTO.setNome("Teste");
        naveRequestDTO.setCor(Cor.AZUL);
        naveRequestDTO.setTotalTripulanteBem(10);
        naveRequestDTO.setGrauAvaria(GrauAvaria.SEM_AVARIAS);
        naveRequestDTO.setPotencialTecnologico(PotencialTecnologico.AVANCADA);
        naveRequestDTO.setTipoCombustivel(TipoCombustivel.ESPRESSO_QUANTICO);
        naveRequestDTO.setTotalTripulanteFerido(10);
        naveRequestDTO.setTotalTripulanteFoiComDeus(40);
        naveRequestDTO.setLocalQueda(LocalQueda.AFRICA);
        naveRequestDTO.setArmamento(Armamento.MISSEL);
        naveRequestDTO.setTamanho(Tamanho.COLOSSAL);

        return naveRequestDTO;
    }
}
