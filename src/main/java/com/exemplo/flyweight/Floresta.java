package com.exemplo.flyweight;

import java.util.ArrayList;
import java.util.List;

public final class Floresta {

    private final FabricaTipoArvore fabrica;
    private final List<Arvore> arvores = new ArrayList<>();

    public Floresta(FabricaTipoArvore fabrica) {
        if (fabrica == null) {
            throw new IllegalArgumentException("Fábrica não pode ser nula");
        }
        this.fabrica = fabrica;
    }

    public Arvore plantar(int x, int y, String nome, String cor, String textura) {
        TipoArvore tipo = fabrica.obterTipo(nome, cor, textura);
        Arvore arvore = new Arvore(x, y, tipo);
        arvores.add(arvore);
        return arvore;
    }

    public List<String> desenhar() {
        List<String> desenhos = new ArrayList<>();
        for (Arvore arvore : arvores) {
            desenhos.add(arvore.desenhar());
        }
        return desenhos;
    }

    public int getQuantidadeArvores() {
        return arvores.size();
    }

    public int getQuantidadeTipos() {
        return fabrica.getQuantidadeTipos();
    }
}
