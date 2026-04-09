package org.example.model

abstract class Pessoa implements InterfacePessoa{
    Integer id
    Integer idEndereco
    String nome
    String email
    String descricao
    String senha


    Pessoa(Integer id, Integer idEndereco, String nome, String email, String descricao, String senha){
        this.id = id
        this.idEndereco = idEndereco
        this.nome = nome
        this.email = email
        this.descricao = descricao
        this.senha = senha
    }

    abstract void exibirPerfil()

}
