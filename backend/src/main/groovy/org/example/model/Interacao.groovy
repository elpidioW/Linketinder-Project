package org.example.model

class Interacao{
    Integer id
    Integer idCandidato
    Integer idVaga
    OrigemInteracao origem
    TipoInteracao tipo

    Interacao(Integer id, Integer idCandidato, Integer idVaga, OrigemInteracao origem, TipoInteracao tipo){
        this.id = id
        this.idCandidato = idCandidato
        this.idVaga = idVaga
        this.origem = origem
        this.tipo = tipo
    }

    void exibirInteracao(){
        println("ID: $id")
        println("Candidato ID: $idCandidato")
        println("Vaga ID: $idVaga")
        println("Origem: ${origem.name()}")
        println("Tipo: ${tipo.name()})")
    }
}
