package org.example.model

enum TipoInteracao {
    LIKE('L'),
    DISLIKE('D')

    final String tipo

    TipoInteracao(String tipo){
        this.tipo = tipo
    }

    static TipoInteracao converteParaEnum(String tipo){
        return values().find {it.tipo == tipo}
    }
}