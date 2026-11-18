package com.exemplo.flyweight;

public final class Arvore {

    private final int x;
    private final int y;
    private final TipoArvore tipo;

    public Arvore(int x, int y, TipoArvore tipo) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordenadas não podem ser negativas");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo não pode ser nulo");
        }
        this.x = x;
        this.y = y;
        this.tipo = tipo;
    }

    public String desenhar() {
        return tipo.desenhar(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TipoArvore getTipo() {
        return tipo;
    }
}
