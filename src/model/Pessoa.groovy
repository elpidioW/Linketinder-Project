package model

abstract class Pessoa implements InterfacePessoa{
    int id
    String nome
    String email
    String estado
    String pais
    String cep
    String descricao
    List<String> competencias

    Pessoa(int id, String nome, String email, String estado, String pais, String cep, String descricao, List<String> competencias){
        this.id = id
        this.nome = nome
        this.email = email
        this.estado = estado
        this.pais = pais
        this.cep = cep
        this.descricao = descricao
        this.competencias = competencias
    }

    abstract void exibirPerfil()

}
