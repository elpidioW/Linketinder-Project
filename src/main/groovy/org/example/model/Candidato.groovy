package org.example.model

class Candidato extends Pessoa{

    String cpf
    int idade

    Candidato(int id, String nome, String email, String estado, String pais, String cep, String descricao, ArrayList<String> competencias, String cpf, int idade){

        super(id, nome, email, estado, pais, cep, descricao, competencias)
        this.cpf = cpf
        this.idade = idade
    }


    @Override
    public void exibirPerfil(){
        println("ID: $id")
        println("Nome: $nome")
        println("Idade: $idade")
        println("CPF: $cpf")
        println("Email: $email")
        println("Estado: $estado")
        println("Pais: $pais")
        println("CEP: $cep")
        println("Descrição: $descricao")
        println("Competências: $competencias")
    }


}
