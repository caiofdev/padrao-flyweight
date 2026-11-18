package com.exemplo.flyweight;

import java.util.HashMap;
import java.util.Map;

public final class FabricaTipoArvore {

    private final Map<String, TipoArvore> cache = new HashMap<>();

    public TipoArvore obterTipo(String nome, String cor, String textura) {
        String chave = nome + "|" + cor + "|" + textura;
        TipoArvore existente = cache.get(chave);
        if (existente != null) {
            return existente;
        }
        TipoArvore novo = new TipoArvore(nome, cor, textura);
        cache.put(chave, novo);
        return novo;
    }

    public int getQuantidadeTipos() {
        return cache.size();
    }
}
