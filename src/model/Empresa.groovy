package model

class Empresa extends Pessoa{

    String cnpj

    Empresa(int id, String nome, String email, String estado, String pais, String cep, String descricao, ArrayList<String> competencias, String cnpj){
        super(id, nome, email, estado, pais, cep, descricao, competencias)
        this.cnpj = cnpj
    }


    @Override
    public void exibirPerfil(){
        println("ID: $id")
        println("Nome: $nome")
        println("CNPJ: $cnpj")
        println("Email: $email")
        println("Estado: $estado")
        println("Pais: $pais")
        println("CEP: $cep")
        println("Descrição: $descricao")
        println("Competências: $competencias")
    }


}
