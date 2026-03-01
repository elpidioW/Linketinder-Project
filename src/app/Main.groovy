package app

import service.CadastroService

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
                    /*print "Nome: "
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

                    print "CPF: "
                    String cpf = scanner.nextLine()

                    print "Idade: "
                    int idade = scanner.nextInt()
                    scanner.nextLine()

                    def candidato = new Candidato(
                            nome, email, estado, pais, cep,
                            descricao, [], cpf, idade
                    )

                    cadastroService.listaCandidatos.add(candidato)

                    println "Candidato criado com sucesso!"*/
                    println(3)
                    break;

                case 4:
                    /*print "Nome da Empresa: "
                    String nomeEmpresa = scanner.nextLine()

                    print "Email: "
                    String emailEmpresa = scanner.nextLine()

                    print "Estado: "
                    String estadoEmpresa = scanner.nextLine()

                    print "País: "
                    String paisEmpresa = scanner.nextLine()

                    print "CEP: "
                    String cepEmpresa = scanner.nextLine()

                    def empresa = new Empresa(
                            nomeEmpresa, emailEmpresa,
                            estadoEmpresa, paisEmpresa, cepEmpresa
                    )

                    cadastroService.listaEmpresas.add(empresa)

                    println "Empresa criada com sucesso!"
                    */
                    println(4);
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


//fazer menu com 5 opções, listar usuario/empresa; criar usuario/empresa; sair
//a validação se o usuario escreveu corretamente vai ser feita aqui


//opção de listar empresas e listar candidatos
//implementar cadastros de candidatos e empresas