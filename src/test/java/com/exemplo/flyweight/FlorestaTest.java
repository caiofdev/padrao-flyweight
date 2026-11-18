package com.exemplo.flyweight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlorestaTest {

    private Floresta floresta;

    @BeforeEach
    void setUp() {
        floresta = new Floresta(new FabricaTipoArvore());
    }

    @Test
    void deveLancarExcecaoQuandoFabricaForNula() {
        assertThrows(IllegalArgumentException.class, () -> new Floresta(null));
    }

    @Test
    void deveCriarFlorestaVaziaQuandoFabricaForValida() {
        assertEquals(0, floresta.getQuantidadeArvores());
        assertEquals(0, floresta.getQuantidadeTipos());
    }

    @Test
    void devePlantarArvoreNaPosicaoInformada() {
        Arvore arvore = floresta.plantar(1, 2, "Pinheiro", "Verde", "Lisa");

        assertEquals(1, arvore.getX());
        assertEquals(2, arvore.getY());
        assertEquals(1, floresta.getQuantidadeArvores());
    }

    @Test
    void deveCompartilharTipoEntreArvoresIguais() {
        Arvore primeira = floresta.plantar(1, 2, "Pinheiro", "Verde", "Lisa");
        Arvore segunda = floresta.plantar(3, 4, "Pinheiro", "Verde", "Lisa");
        floresta.plantar(5, 6, "Carvalho", "Marrom", "Rugosa");

        assertSame(primeira.getTipo(), segunda.getTipo());
        assertEquals(3, floresta.getQuantidadeArvores());
        assertEquals(2, floresta.getQuantidadeTipos());
    }

    @Test
    void deveRetornarListaVaziaAoDesenharFlorestaSemArvores() {
        assertTrue(floresta.desenhar().isEmpty());
    }

    @Test
    void deveDesenharTodasAsArvoresDaFloresta() {
        floresta.plantar(1, 2, "Pinheiro", "Verde", "Lisa");
        floresta.plantar(5, 6, "Carvalho", "Marrom", "Rugosa");

        List<String> desenhos = floresta.desenhar();

        assertEquals(List.of(
                "Pinheiro [Verde, Lisa] em (1, 2)",
                "Carvalho [Marrom, Rugosa] em (5, 6)"), desenhos);
    }
}
