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
