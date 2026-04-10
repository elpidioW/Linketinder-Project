package org.example.model

class Match {
    Integer idVaga
    Integer idCandidato

    Match(Integer idVaga, Integer idCandidato){
        this.idVaga = idVaga
        this.idCandidato = idCandidato
    }

    void exibirMatch(){
        println("Match: $idCandidato + $idVaga ")
    }
}
