package org.example.model

enum OrigemInteracao {
    CANDIDATO('C'),
    EMPRESA('E')

    final String origem

    OrigemInteracao(String origem) {
        this.origem = origem
    }
}