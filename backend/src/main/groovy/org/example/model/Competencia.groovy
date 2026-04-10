package org.example.model

class Competencia {
    Integer id
    String nome

    Competencia(String nome){
        this.nome = nome
    }

    Competencia(Integer id, String nome){
        this.id = id
        this.nome = nome
    }

    public void exibiCompetencia(){
        println("ID: $id")
        println("Nome: $nome")
    }
}
