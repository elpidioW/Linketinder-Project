package org.example.model

enum OrigemInteracao {
    CANDIDATO('C'),
    EMPRESA('E')

    final String origem

    OrigemInteracao(String origem) {
        this.origem = origem
    }

    static TipoInteracao converteParaEnum(String origem){
        return values().find {it.origem == origem}
    }
}