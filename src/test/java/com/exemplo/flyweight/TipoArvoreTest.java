package com.exemplo.flyweight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TipoArvoreTest {

    @Test
    void deveLancarExcecaoQuandoNomeForNulo() {
        assertThrows(IllegalArgumentException.class, () -> new TipoArvore(null, "Verde", "Lisa"));
    }

    @Test
    void deveLancarExcecaoQuandoNomeForVazio() {
        assertThrows(IllegalArgumentException.class, () -> new TipoArvore("  ", "Verde", "Lisa"));
    }

    @Test
    void deveLancarExcecaoQuandoCorForNula() {
        assertThrows(IllegalArgumentException.class, () -> new TipoArvore("Pinheiro", null, "Lisa"));
    }

    @Test
    void deveLancarExcecaoQuandoCorForVazia() {
        assertThrows(IllegalArgumentException.class, () -> new TipoArvore("Pinheiro", "", "Lisa"));
    }

    @Test
    void deveLancarExcecaoQuandoTexturaForNula() {
        assertThrows(IllegalArgumentException.class, () -> new TipoArvore("Pinheiro", "Verde", null));
    }

    @Test
    void deveLancarExcecaoQuandoTexturaForVazia() {
        assertThrows(IllegalArgumentException.class, () -> new TipoArvore("Pinheiro", "Verde", " "));
    }

    @Test
    void deveCriarTipoQuandoDadosForemValidos() {
        TipoArvore tipo = new TipoArvore("Pinheiro", "Verde", "Lisa");

        assertEquals("Pinheiro", tipo.getNome());
        assertEquals("Verde", tipo.getCor());
        assertEquals("Lisa", tipo.getTextura());
    }

    @Test
    void deveDesenharComCoordenadasInformadas() {
        TipoArvore tipo = new TipoArvore("Pinheiro", "Verde", "Lisa");

        assertEquals("Pinheiro [Verde, Lisa] em (3, 7)", tipo.desenhar(3, 7));
    }
}
