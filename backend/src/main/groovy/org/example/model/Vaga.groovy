package org.example.model

class Vaga {
    Integer id
    Integer idEndereco
    Integer idEmpresa
    String nome
    String descricao
    Boolean ativa
    List<String> competencias

    Vaga(Integer id, Integer idEndereco, Integer idEmpresa, String nome, String descricao, Boolean ativa, List<String> competencias) {
        this.id = id
        this.idEndereco = idEndereco
        this.idEmpresa = idEmpresa
        this.nome = nome
        this.descricao = descricao
        this.ativa = ativa
        this.competencias = competencias
    }

    void exibirVaga() {
        println("ID: $id")
        println("Nome: $nome")
        println("Descrição: $descricao")
        println("Ativa: ${ativa ? 'Sim' : 'Não'}")
        println("Competências: $competencias")
    }
}