package com.exemplo.flyweight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FabricaTipoArvoreTest {

    private FabricaTipoArvore fabrica;

    @BeforeEach
    void setUp() {
        fabrica = new FabricaTipoArvore();
    }

    @Test
    void deveCriarNovoTipoQuandoNaoExistirNoCache() {
        TipoArvore tipo = fabrica.obterTipo("Pinheiro", "Verde", "Lisa");

        assertEquals("Pinheiro", tipo.getNome());
        assertEquals(1, fabrica.getQuantidadeTipos());
    }

    @Test
    void deveReutilizarTipoQuandoJaExistirNoCache() {
        TipoArvore primeiro = fabrica.obterTipo("Pinheiro", "Verde", "Lisa");
        TipoArvore segundo = fabrica.obterTipo("Pinheiro", "Verde", "Lisa");

        assertSame(primeiro, segundo);
        assertEquals(1, fabrica.getQuantidadeTipos());
    }

    @Test
    void deveCriarTiposDistintosParaDadosDiferentes() {
        TipoArvore pinheiro = fabrica.obterTipo("Pinheiro", "Verde", "Lisa");
        TipoArvore carvalho = fabrica.obterTipo("Carvalho", "Marrom", "Rugosa");

        assertNotSame(pinheiro, carvalho);
        assertEquals(2, fabrica.getQuantidadeTipos());
    }

    @Test
    void deveRetornarZeroTiposQuandoCacheEstiverVazio() {
        assertEquals(0, fabrica.getQuantidadeTipos());
    }
}
