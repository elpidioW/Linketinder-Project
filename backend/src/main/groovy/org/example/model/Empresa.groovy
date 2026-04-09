package org.example.model


class Empresa extends Pessoa{

    String cnpj

    Empresa(Integer id, Integer idEndereco, String nome, String email, String descricao, String senha, String cnpj){
        super(id, idEndereco, nome, email, descricao, senha)
        this.cnpj = cnpj
    }


    @Override
    public void exibirPerfil(){
        println("ID: $id")
        println("Nome: $nome")
        println("CNPJ: $cnpj")
        println("Email: $email")
        /*println("Cidade: $cidade - $estado")
        println("Pais: $pais")
        println("CEP: $cep")*/
        println("Descrição: $descricao")
    }
}
