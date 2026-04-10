package org.example.model

class Endereco{
    Integer id
    String cep
    String cidade
    String estado
    String pais

    Endereco(Integer id, String cep, String cidade, String estado, String pais) {
        this.id = id
        this.cep = cep
        this.cidade = cidade
        this.estado = estado
        this.pais = pais
    }

    Endereco(String cep, String cidade, String estado, String pais) {
        this.cep = cep
        this.cidade = cidade
        this.estado = estado
        this.pais = pais
    }

    public void exibirEndereco() {
        println("ID: $id")
        println("CEP: $cep")
        println("Cidade: $cidade")
        println("Estado: $estado")
        println("Pais: $pais")
    }
}