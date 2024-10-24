package com.ehpatho.api;

import com.ehpatho.api.dto.NaveRequestDTO;
import com.ehpatho.api.dto.NaveResponseDTO;
import com.ehpatho.api.enumerated.*;
import com.patos.alens.demo.enumerated.*;
import com.ehpatho.api.repository.NaveRepository;
import com.ehpatho.api.service.NaveService;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * A classe NaveServiceTest é responsável por realizar testes unitarios da classe NaveService
 *
 * @author Kaique Queiros kaique_q@outlook.com
 */
@SpringBootTest
@AutoConfigureMockMvc
public class NaveServiceTest {
    @MockBean
    private NaveService naveService;
    @MockBean
    private NaveRepository naveRepository;

    @BeforeEach
    public void init() {
        naveService = new NaveService(naveRepository);
    }

    @Test
    @Transactional
    public void testaBuscarTodasAsNaves() {
        List<NaveResponseDTO> naveResponseDTOList = naveService.listaNaves();
        Assertions.assertEquals(0, naveResponseDTOList.size());
    }

    @Test
    @Transactional
    public void testaCriarNovaNave_Success() throws BadRequestException {
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

        NaveResponseDTO naveResponseDTO = naveService.criarNave(naveRequestDTO);

        Assertions.assertEquals("Teste", naveResponseDTO.getNome());
        Assertions.assertEquals(Cor.AZUL.getNome(), naveResponseDTO.getCor());
    }

    @Test
    @Transactional
    public void testaCriarNaveComNomeExistente() {
        Mockito.when(this.naveRepository.existsByNome(Mockito.anyString())).thenReturn(true);
        NaveRequestDTO naveRequestDTO = new NaveRequestDTO();
        naveRequestDTO.setNome("Nave Fênix");
        naveRequestDTO.setCor(Cor.AZUL);
        naveRequestDTO.setTotalTripulanteBem(10);
        naveRequestDTO.setGrauAvaria(GrauAvaria.SEM_AVARIAS);
        naveRequestDTO.setPotencialTecnologico(PotencialTecnologico.AVANCADA);
        naveRequestDTO.setTipoCombustivel(TipoCombustivel.ESPRESSO_QUANTICO);
        naveRequestDTO.setTotalTripulanteFerido(10);
        naveRequestDTO.setTotalTripulanteFoiComDeus(40);

        assertThrows(BadRequestException.class, () -> {
            naveService.criarNave(naveRequestDTO);
        });
    }

}
