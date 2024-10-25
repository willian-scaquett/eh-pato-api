package com.ehpatho.api.service;

import com.ehpatho.api.entity.Nave;
import com.ehpatho.api.enumerated.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NaveClassificadorTest {

    private NaveClassificador naveClassificador;

    @BeforeEach
    public void setUp() {
        naveClassificador = new NaveClassificador();
    }

    private static Nave getNave() {
        Nave nave = new Nave();
        nave.setLocalQueda(LocalQueda.OCEANO_GLACIAL_ARTICO);
        nave.setArmamento(Armamento.OGIVA_NUCLEAR);
        nave.setTipoCombustivel(TipoCombustivel.GERADOR_PROBABILIDADE_INFINITA);
        nave.setTamanho(Tamanho.MEDIA);
        nave.setPotencialTecnologico(PotencialTecnologico.PRIMITIVA);
        nave.setGrauAvaria(GrauAvaria.PRATICAMENTE_INTACTA);
        nave.setTotalTripulanteBem(10);
        nave.setTotalTripulanteFerido(5);
        nave.setTotalTripulanteFoiComDeus(2);

        return nave;
    }

    @Test
    public void testClassificarPerigo_BaixissimaPericulosidade() {
        Nave nave = getNave();

        nave.setLocalQueda(LocalQueda.ASIA);
        nave.setArmamento(Armamento.LASER);
        nave.setTipoCombustivel(TipoCombustivel.LAGRIMAS_DE_UNICORNIO);
        nave.setTotalTripulanteBem(0);
        nave.setTotalTripulanteFerido(0);
        nave.setTotalTripulanteFoiComDeus(0);

        Nave resultado = naveClassificador.definirCategoriaEPericulosidade(nave);
        assertEquals(Periculosidade.BAIXISSIMA, resultado.getPericulosidade());
    }

    @Test
    public void testClassificarPerigo_BaixaPericulosidade() {
        Nave nave = getNave();

        nave.setLocalQueda(LocalQueda.ASIA);
        nave.setArmamento(Armamento.LASER);
        nave.setTipoCombustivel(TipoCombustivel.LAGRIMAS_DE_UNICORNIO);
        nave.setTotalTripulanteBem(5);
        nave.setTotalTripulanteFerido(0);
        nave.setTotalTripulanteFoiComDeus(0);

        Nave resultado = naveClassificador.definirCategoriaEPericulosidade(nave);
        assertEquals(Periculosidade.BAIXA, resultado.getPericulosidade());
    }

    @Test
    public void testClassificarPerigo_MediaPericulosidade() {
        Nave nave = getNave();

        nave.setLocalQueda(LocalQueda.ASIA);
        nave.setArmamento(Armamento.LASER);
        nave.setTipoCombustivel(TipoCombustivel.LAGRIMAS_DE_UNICORNIO);
        nave.setTotalTripulanteBem(10);
        nave.setTotalTripulanteFerido(10);
        nave.setTotalTripulanteFoiComDeus(0);

        Nave resultado = naveClassificador.definirCategoriaEPericulosidade(nave);
        assertEquals(Periculosidade.MEDIA, resultado.getPericulosidade());
    }

    @Test
    public void testClassificarPerigo_AltaPericulosidade() {
        Nave nave = getNave();

        nave.setLocalQueda(LocalQueda.ASIA);
        nave.setArmamento(Armamento.LASER);
        nave.setTipoCombustivel(TipoCombustivel.LAGRIMAS_DE_UNICORNIO);
        nave.setTotalTripulanteBem(10);
        nave.setTotalTripulanteFerido(20);
        nave.setTotalTripulanteFoiComDeus(20);

        Nave resultado = naveClassificador.definirCategoriaEPericulosidade(nave);
        assertEquals(Periculosidade.ALTA, resultado.getPericulosidade());
    }

    @Test
    public void testClassificarPerigo_AltissimaPericulosidade() {
        Nave nave = getNave();

        nave.setTipoCombustivel(TipoCombustivel.GERADOR_PROBABILIDADE_INFINITA);
        nave.setTotalTripulanteBem(20);

        Nave resultado = naveClassificador.definirCategoriaEPericulosidade(nave);
        assertEquals(Periculosidade.ALTISSIMA, resultado.getPericulosidade());
    }

    @Test
    public void testClassificarNave_AmeacaEmPotencial() {
        Nave nave = getNave();

        nave.setTamanho(Tamanho.COLOSSAL);
        nave.setPotencialTecnologico(PotencialTecnologico.TRANSCENDENTE);
        nave.setTotalTripulanteBem(20);

        Nave resultado = naveClassificador.definirCategoriaEPericulosidade(nave);
        assertEquals(Classificacao.AMEACA_EM_POTENCIAL, resultado.getClassificacao());
    }

    @Test
    public void testClassificarNave_JoiaTecnologica() {
        Nave nave = getNave();

        nave.setTamanho(Tamanho.COLOSSAL);
        nave.setPotencialTecnologico(PotencialTecnologico.TRANSCENDENTE);

        Nave resultado = naveClassificador.definirCategoriaEPericulosidade(nave);
        assertEquals(Classificacao.JOIA_TECNOLOGICA, resultado.getClassificacao());
    }

    @Test
    public void testClassificarNave_ArsenalAlienigena() {
        Nave nave = getNave();

        nave.setArmamento(Armamento.OGIVA_NUCLEAR);
        nave.setTamanho(Tamanho.COLOSSAL);
        nave.setPotencialTecnologico(PotencialTecnologico.TRANSCENDENTE);
        nave.setTipoCombustivel(TipoCombustivel.PLUTONIO);
        nave.setTotalTripulanteBem(0);
        nave.setTotalTripulanteFerido(0);
        nave.setTotalTripulanteFoiComDeus(0);

        Nave resultado = naveClassificador.definirCategoriaEPericulosidade(nave);
        assertEquals(Classificacao.ARSENAL_ALIENIGENA, resultado.getClassificacao());
    }

    @Test
    public void testClassificarNave_FonteDeEnergia() {
        Nave nave = getNave();

        nave.setArmamento(Armamento.BOMBA);
        nave.setTamanho(Tamanho.COLOSSAL);
        nave.setPotencialTecnologico(PotencialTecnologico.TRANSCENDENTE);
        nave.setTipoCombustivel(TipoCombustivel.GERADOR_PROBABILIDADE_INFINITA);
        nave.setTotalTripulanteBem(0);
        nave.setTotalTripulanteFerido(0);
        nave.setTotalTripulanteFoiComDeus(0);

        Nave resultado = naveClassificador.definirCategoriaEPericulosidade(nave);
        assertEquals(Classificacao.FONTE_DE_ENERGIA, resultado.getClassificacao());
    }

    @Test
    public void testClassificarNave_SucataEspacial() {
        Nave nave = getNave();

        Nave resultado = naveClassificador.definirCategoriaEPericulosidade(nave);
        assertEquals(Classificacao.SUCATA_ESPACIAL, resultado.getClassificacao());
    }
}

