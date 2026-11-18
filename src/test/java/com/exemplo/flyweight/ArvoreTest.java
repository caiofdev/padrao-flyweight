package com.exemplo.flyweight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ArvoreTest {

    private final TipoArvore tipo = new TipoArvore("Pinheiro", "Verde", "Lisa");

    @Test
    void deveLancarExcecaoQuandoXForNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Arvore(-1, 0, tipo));
    }

    @Test
    void deveLancarExcecaoQuandoYForNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Arvore(0, -1, tipo));
    }

    @Test
    void deveLancarExcecaoQuandoTipoForNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Arvore(0, 0, null));
    }

    @Test
    void deveCriarArvoreQuandoDadosForemValidos() {
        Arvore arvore = new Arvore(2, 5, tipo);

        assertEquals(2, arvore.getX());
        assertEquals(5, arvore.getY());
        assertSame(tipo, arvore.getTipo());
    }

    @Test
    void deveDesenharUsandoEstadoExtrinseco() {
        Arvore arvore = new Arvore(2, 5, tipo);

        assertEquals("Pinheiro [Verde, Lisa] em (2, 5)", arvore.desenhar());
    }
}
