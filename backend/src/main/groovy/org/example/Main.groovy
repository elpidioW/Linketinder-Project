package org.example

import groovy.sql.Sql
import org.example.dao.Database
import org.example.service.CandidatoService
import org.example.service.EmpresaService
import org.example.service.VagaService

import java.time.LocalDate

class Main {

    static void main(String[] args) {

        Sql sql = Database.getConnection()
        def candidatoService = new CandidatoService(sql)
        def empresaService = new EmpresaService(sql)
        def vagaService = new VagaService(sql)

        def scanner = new Scanner(System.in)
        int opcao = -1

        while (opcao != 0) {

            println """
===== MENU PRINCIPAL =====
--- CANDIDATOS ---
1  - Listar candidatos
2  - Buscar candidato por ID
3  - Criar candidato
4  - Atualizar candidato
5  - Deletar candidato
--- EMPRESAS ---
6  - Listar empresas
7  - Buscar empresa por ID
8  - Criar empresa
9  - Atualizar empresa
10 - Deletar empresa
--- VAGAS ---
11 - Listar vagas
12 - Buscar vaga por ID
13 - Criar vaga
14 - Atualizar vaga
15 - Deletar vaga
--- 
0  - Sair
=========================="""
            print "Escolha uma opção: "
            opcao = scanner.nextInt()
            scanner.nextLine()

            switch (opcao) {
                case 1:
                    candidatoService.listarCandidatos()
                    break

                case 2:
                    print "ID do candidato: "
                    CandidatoService.buscarCandidato(scanner.nextInt())
                    scanner.nextLine()
                    break

                case 3:
                    print "Nome: "
                    String nome = scanner.nextLine()
                    print "Sobrenome: "
                    String sobrenome = scanner.nextLine()
                    print "Email: "
                    String email = scanner.nextLine()
                    print "CPF (apenas números): "
                    String cpf = scanner.nextLine()
                    print "Data de nascimento (AAAA-MM-DD): "
                    LocalDate dataNasc = LocalDate.parse(scanner.nextLine())
                    print "CEP (apenas números): "
                    String cep = scanner.nextLine()
                    print "Cidade: "
                    String cidade = scanner.nextLine()
                    print "Estado: "
                    String estado = scanner.nextLine()
                    print "País: "
                    String pais = scanner.nextLine()
                    print "Descrição: "
                    String descricao = scanner.nextLine()
                    print "Senha: "
                    String senha = scanner.nextLine()
                    print "Competências (separadas por vírgula): "
                    List<String> competencias = scanner.nextLine().tokenize(",")*.trim()
                    candidatoService.cadastrarCandidato(nome, sobrenome, email, cep, cidade, estado, pais, descricao, senha, competencias, cpf, dataNasc)
                    break

                case 4:
                    print "ID do candidato a atualizar: "
                    Integer idCand = scanner.nextInt()
                    scanner.nextLine()
                    print "Novo nome: "
                    String nome = scanner.nextLine()
                    print "Novo sobrenome: "
                    String sobrenome = scanner.nextLine()
                    print "Novo email: "
                    String email = scanner.nextLine()
                    print "Novo CPF (apenas números): "
                    String cpf = scanner.nextLine()
                    print "Nova data de nascimento (AAAA-MM-DD): "
                    LocalDate dataNasc = LocalDate.parse(scanner.nextLine())
                    print "Novo CEP (apenas números): "
                    String cep = scanner.nextLine()
                    print "Nova cidade: "
                    String cidade = scanner.nextLine()
                    print "Novo estado: "
                    String estado = scanner.nextLine()
                    print "Novo país: "
                    String pais = scanner.nextLine()
                    print "Nova descrição: "
                    String descricao = scanner.nextLine()
                    print "Nova senha: "
                    String senha = scanner.nextLine()
                    print "Novas competências (separadas por vírgula): "
                    List<String> competencias = scanner.nextLine().tokenize(",")*.trim()
                    candidatoService.atualizarCandidato(idCand, nome, sobrenome, email, cep, cidade, estado, pais, descricao, senha, competencias, cpf, dataNasc)
                    break

                case 5:
                    print "ID do candidato a deletar: "
                    candidatoService.deletarCandidato(scanner.nextInt())
                    scanner.nextLine()
                    break



                case 6:
                    empresaService.listarEmpresas()
                    break

                case 7:
                    print "ID da empresa: "
                    empresaService.buscarEmpresa(scanner.nextInt())
                    scanner.nextLine()
                    break

                case 8:
                    print "Nome: "
                    String nome = scanner.nextLine()
                    print "Email: "
                    String email = scanner.nextLine()
                    print "CNPJ (apenas números): "
                    String cnpj = scanner.nextLine()
                    print "CEP (apenas números): "
                    String cep = scanner.nextLine()
                    print "Cidade: "
                    String cidade = scanner.nextLine()
                    print "Estado: "
                    String estado = scanner.nextLine()
                    print "País: "
                    String pais = scanner.nextLine()
                    print "Descrição: "
                    String descricao = scanner.nextLine()
                    print "Senha: "
                    String senha = scanner.nextLine()
                    print "Competências esperadas (separadas por vírgula): "
                    List<String> competencias = scanner.nextLine().tokenize(",")*.trim()
                    empresaService.cadastrarEmpresa(nome, email, cep, cidade, estado, pais, descricao, senha, competencias, cnpj)
                    break

                case 9:
                    print "ID da empresa a atualizar: "
                    Integer idEmp = scanner.nextInt()
                    scanner.nextLine()
                    print "Novo nome: "
                    String nome = scanner.nextLine()
                    print "Novo email: "
                    String email = scanner.nextLine()
                    print "Novo CNPJ (apenas números): "
                    String cnpj = scanner.nextLine()
                    print "Novo CEP (apenas números): "
                    String cep = scanner.nextLine()
                    print "Nova cidade: "
                    String cidade = scanner.nextLine()
                    print "Novo estado: "
                    String estado = scanner.nextLine()
                    print "Novo país: "
                    String pais = scanner.nextLine()
                    print "Nova descrição: "
                    String descricao = scanner.nextLine()
                    print "Nova senha: "
                    String senha = scanner.nextLine()
                    empresaService.atualizarEmpresa(idEmp, nome, email, cep, cidade, estado, pais, descricao, senha, cnpj)
                    break

                case 10:
                    print "ID da empresa a deletar: "
                    empresaService.deletarEmpresa(scanner.nextInt())
                    scanner.nextLine()
                    break

                    // ========== VAGAS ==========

                case 11:
                    vagaService.listarVagas()
                    break

                case 12:
                    print "ID da vaga: "
                    vagaService.buscarVaga(scanner.nextInt())
                    scanner.nextLine()
                    break

                case 13:
                    print "ID da empresa responsável: "
                    Integer idEmp = scanner.nextInt()
                    scanner.nextLine()
                    print "Nome da vaga: "
                    String nome = scanner.nextLine()
                    print "Descrição: "
                    String descricao = scanner.nextLine()
                    print "CEP (apenas números): "
                    String cep = scanner.nextLine()
                    print "Cidade: "
                    String cidade = scanner.nextLine()
                    print "Estado: "
                    String estado = scanner.nextLine()
                    print "País: "
                    String pais = scanner.nextLine()
                    print "Competências (separadas por vírgula): "
                    List<String> competencias = scanner.nextLine().tokenize(",")*.trim()
                    vagaService.cadastrarVaga(idEmp, nome, descricao, cep, cidade, estado, pais, competencias)
                    break

                case 14:
                    print "ID da vaga a atualizar: "
                    Integer idVaga = scanner.nextInt()
                    scanner.nextLine()
                    print "Novo nome: "
                    String nome = scanner.nextLine()
                    print "Nova descrição: "
                    String descricao = scanner.nextLine()
                    print "Vaga ativa? (s/n): "
                    Boolean ativa = scanner.nextLine().trim().toLowerCase() == "s"
                    print "Novo CEP (apenas números): "
                    String cep = scanner.nextLine()
                    print "Nova cidade: "
                    String cidade = scanner.nextLine()
                    print "Novo estado: "
                    String estado = scanner.nextLine()
                    print "Novo país: "
                    String pais = scanner.nextLine()
                    print "Novas competências (separadas por vírgula): "
                    List<String> competencias = scanner.nextLine().tokenize(",")*.trim()
                    vagaService.atualizarVaga(idVaga, nome, descricao, ativa, cep, cidade, estado, pais, competencias)
                    break

                case 15:
                    print "ID da vaga a deletar: "
                    vagaService.deletarVaga(scanner.nextInt())
                    scanner.nextLine()
                    break

                case 0:
                    println "Encerrando o sistema..."
                    break

                default:
                    println "Opção inválida!"
            }
        }
        sql.close()
    }
}