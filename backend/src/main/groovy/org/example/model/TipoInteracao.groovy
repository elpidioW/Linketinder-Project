package org.example.model

enum TipoInteracao {
    LIKE('L'),
    DISLIKE('D')

    final String tipo

    TipoInteracao(String interacao){
        this.interacao = interacao
    }
}