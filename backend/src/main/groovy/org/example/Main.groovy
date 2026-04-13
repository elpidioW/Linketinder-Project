package org.example

import groovy.sql.Sql
import org.example.dao.CandidatoDAO
import org.example.dao.CompetenciaDAO
import org.example.dao.Database
import org.example.dao.EmpresaDAO
import org.example.dao.VagaDAO
import org.example.dao.EnderecoDAO

class Main {

    static void main(String[] args) {

        Sql sql = Database.getConnection()
        def enderecoDAO = new EnderecoDAO(sql)
        def competenciaDAO = new CompetenciaDAO(sql)
        def candidatoDAO = new CandidatoDAO(sql)
        def empresaDAO = new EmpresaDAO(sql)
        def vagaDAO = new VagaDAO(sql)

        println "✅ Conectado!"

        sql.close()
    }
}


/*

class Main {

    static void main(String[] args) {

        def cadastroService = new CadastroService()
        cadastroService.popularBanco()
        def scanner = new Scanner(System.in)

        int opcao = -1
        while (opcao != 5) {

            println "\n===== MENU ====="
            println "1 - Listar Candidatos"
            println "2 - Listar Empresas"
            println "3 - Criar Candidato"
            println "4 - Criar Empresa"
            println "5 - Sair"
            print "Escolha uma opção: "

            opcao = scanner.nextInt()
            scanner.nextLine() // limpar buffer

            switch (opcao) {

                case 1:
                    cadastroService.listarCandidatos()
                    break;

                case 2:
                    cadastroService.listarEmpresas()

                    break;

                case 3:
                    print "Nome: "
                    String nome = scanner.nextLine()

                    print "Email: "
                    String email = scanner.nextLine()

                    print "Estado: "
                    String estado = scanner.nextLine()

                    print "País: "
                    String pais = scanner.nextLine()

                    print "CEP: "
                    String cep = scanner.nextLine()

                    print "Descrição: "
                    String descricao = scanner.nextLine()

                    print "Digite suas competencias separadas por virgula: "
                    String compLinha = scanner.nextLine()
                    ArrayList<String> competencias = compLinha.tokenize(",")

                    print "CPF: "
                    String cpf = scanner.nextLine()

                    print "Idade: "
                    int idade = scanner.nextInt()
                    scanner.nextLine()

                    cadastroService.cadastrarCandidato(nome, email, estado, pais, cep, descricao, competencias, cpf, idade)
                    break;

                case 4:
                    print "Nome: "
                    String nome = scanner.nextLine()

                    print "Email: "
                    String email = scanner.nextLine()

                    print "Estado: "
                    String estado = scanner.nextLine()

                    print "País: "
                    String pais = scanner.nextLine()

                    print "CEP: "
                    String cep = scanner.nextLine()

                    print "Descrição: "
                    String descricao = scanner.nextLine()

                    print "Digite as competencias esperadas pela empresa separadas por virgula: "
                    String compLinha = scanner.nextLine()
                    ArrayList<String> competencias = compLinha.tokenize(",")

                    print "CNPJ: "
                    String cnpj = scanner.nextLine()

                    cadastroService.cadastrarEmpresa(nome, email, estado, pais, cep, descricao, competencias, cnpj)
                    break

                case 5:
                    println "Encerrando o sistema..."
                    break

                default:
                    println "Opção inválida!"
            }
        }
    }
}
*/





/*



TESTES ENDEREÇO
enderecoDAO.delete(7)


 Busca o endereço atual para confirmar antes do update
 def endereco = enderecoDAO.select(1)
 println("Antes: $endereco")

 //Atualiza os dados
 endereco.cep    = '74001000'
 endereco.cidade = 'Aparecida de Goiânia'

 boolean atualizado = enderecoDAO.update(endereco)

 if (atualizado) {
     def enderecoAtualizado = enderecoDAO.select(1)
     println("Depois: $enderecoAtualizado")
 } else {
     println("Endereço não encontrado.")
 }

def endereco = new Endereco(
        "69007826",
        "Manaus",
        "AM",
        "Brasil"
)
//endereco1.exibirEndereco()
//Integer idEndereco = enderecoDAO.insert(endereco);
//println(idEndereco)
println(enderecoDAO.retornarEnderecoPeloID(1))


sql.eachRow("SELECT  * FROM endereco"){ row ->

    println ("${row.id} - ${row.cidade}")
}
*/






/*
TESTE COMPETENCIAS

        def comp = new Competencia("java")
        def id = competenciaDAO.insert(comp)
        println(id)

        def id1 = competenciaDAO.insert(new Competencia(null, "Groovy"))
        def id2 = competenciaDAO.insert(new Competencia(null, "Groovy"))

        println "ID1: $id1"
        println "ID2: $id2"

        def comp = new Competencia(null, "SQL")
        def id = competenciaDAO.insert(comp)

        def resultado = competenciaDAO.select(id)

        println resultado?.nome



        competenciaDAO.insert(new Competencia(null, "Python"))
        def RES = competenciaDAO.buscarPorNome("Python")
        println RES?.id
        println RES?.nome


        def id = competenciaDAO.insert(new Competencia("c"))

        def compAtualizado = new Competencia(id, "C")

        def linhas = competenciaDAO.update(compAtualizado)

        println "Linhas afetadas: $linhas"

        def novo = competenciaDAO.select(id)
        println novo.nome

        def linhas = competenciaDAO.delete(10)

        println "Linhas deletadas: $linhas"

        def resultado = competenciaDAO.select(10)
        println resultado  // deve ser null
 */



/*

TESTE CANDIDATO
       def endereco = new Endereco("69005070", "Manaus", "AM", "Brasil")

       def candidato = new Candidato(
               null,
               null,
               "rafa",
               "não silva",
               "sr@email.com",
               "23154768009",
               LocalDate.of(2000, 1, 1),
               "Dev backend",
               "123456",
               ["c#", "c++", "Java"] // competências
       )

       def id = candidatoDAO.insert(candidato, endereco)

       println "ID candidato: $id"

       def candidato = candidatoDAO.select(1)

       def endereco = new Endereco(
               candidato.idEndereco,
               "70000000",
               "Brasília",
               "DF",
               "Brasil"
       )

       candidato.competencias = ["C#", "C"]
       candidato.nome = "João Atualizado"
       candidato.email = "novo@email.com"

       candidatoDAO.update(candidato, endereco)

       def atualizado = candidatoDAO.select(1)
       println atualizado.nome
       println atualizado.email



       def resultado = candidatoDAO.delete(13)

       println "Linhas deletadas: $resultado"

       def candidato = candidatoDAO.select(13)
       println candidato  // deve ser null
*/

/*
        EMPRESAS

        def endereco = new Endereco("70000000", "Brasília", "DF", "Brasil")

        def empresa = new Empresa(
                null,
                null,
                "Tech Corp",
                "tech1@email.com",
                "Empresa de tecnologia",
                "123456",
                "12345678000961"
        )

        def id = empresaDAO.insert(empresa, endereco)

        println "ID empresa: $id"

        def empresa = empresaDAO.select(1)

        println empresa?.nome
        println empresa?.cnpj

        def empresa = empresaDAO.select(1)

        def endereco = new Endereco(
                empresa.idEndereco,
                "80000000",
                "Curitiba",
                "PR",
                "Brasil"
        )

        empresa.nome = "Tech Corp Atualizada"
        empresa.email = "novo@email.com"

        def linhas = empresaDAO.update(empresa, endereco)

        println "Linhas afetadas: $linhas"

        def atualizado = empresaDAO.select(1)
        println atualizado.nome
        println atualizado.email

        def linhas = empresaDAO.delete(1)

        println "Linhas deletadas: $linhas"

        def empresa = empresaDAO.select(1)
        println empresa  // deve ser null

   */


 /*
        VAGA

        def vaga = new Vaga(
                null,
                null,
                8,
                "Dev Backend",
                "Trabalhar com APIs",
                true,
                ["Java", "SQL"]
        )

        def endereco = new Endereco(
                "70000000",
                "Brasília",
                "DF",
                "Brasil"
        )

        def idVaga = vagaDAO.insert(vaga, endereco)
        println "ID vaga: $idVaga"


        def vaga = vagaDAO.select(10)

        println vaga?.nome
        println vaga?.competencias

        def vagas = vagaDAO.listarVagasAtivasPorEmpresa(3)

        vagas.each {
            println "${it.id} - ${it.nome}"
        }



        def vaga = vagaDAO.select(4)

        def endereco = new Endereco(
                vaga.idEndereco,
                "80000000",
                "Curitiba",
                "PR",
                "Brasil"
        )

        vaga.nome = "Dev Backend Senior"
        vaga.ativa = false
        vaga.competencias = ["Java"] // remove SQL

        vagaDAO.update(vaga, endereco)

        def atualizada = vagaDAO.select(4)

        println atualizada.nome
        println atualizada.ativa
        println atualizada.competencias


        def linhas = vagaDAO.delete(5)

        println "Linhas deletadas: $linhas"

        println vagaDAO.select(5) // null*/