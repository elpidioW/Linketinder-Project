package org.example.model

import java.time.LocalDate
import java.time.Period

class Candidato extends Pessoa{

    String sobrenome
    String cpf
    LocalDate dataNascimento
    List<String> competencias

    Candidato(Integer id, Integer idEndereco, String nome, String sobrenome, String email, String cpf, LocalDate dataNascimento,
              String cep, String cidade, String estado, String pais, String descricao, String senha, List<String> competencias){
        super(id, idEndereco, nome, email, cep, cidade, estado, pais, descricao, senha)
        this.sobrenome = sobrenome
        this.cpf = cpf
        this.dataNascimento = dataNascimento
        this.competencias = competencias
    }

    int getIdade(){
        return Period.between(dataNascimento, LocalDate.now()).years
    }


    @Override
    public void exibirPerfil(){
        println("ID: $id")
        println("Nome: $nome $sobrenome")
        println("Idade: ${getIdade()} anos")
        println("CPF: $cpf")
        println("Email: $email")
        println("Cidade: $cidade - $estado")
        println("Pais: $pais")
        println("CEP: $cep")
        println("Descrição: $descricao")
        println("Competências: $competencias")
    }
}
