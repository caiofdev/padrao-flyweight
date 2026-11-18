package com.exemplo.flyweight;

public final class TipoArvore {

    private final String nome;
    private final String cor;
    private final String textura;

    public TipoArvore(String nome, String cor, String textura) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (cor == null || cor.isBlank()) {
            throw new IllegalArgumentException("Cor não pode ser vazia");
        }
        if (textura == null || textura.isBlank()) {
            throw new IllegalArgumentException("Textura não pode ser vazia");
        }
        this.nome = nome;
        this.cor = cor;
        this.textura = textura;
    }

    public String desenhar(int x, int y) {
        return "%s [%s, %s] em (%d, %d)".formatted(nome, cor, textura, x, y);
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public String getTextura() {
        return textura;
    }
}
