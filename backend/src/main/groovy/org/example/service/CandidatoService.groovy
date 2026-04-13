package org.example.service

import groovy.sql.Sql
import org.example.dao.CandidatoDAO
import org.example.model.Candidato
import org.example.model.Endereco

import java.time.LocalDate

class CandidatoService {

    private CandidatoDAO candidatoDAO

    CandidatoService(Sql sql){
        this.candidatoDAO = new CandidatoDAO(sql)
    }

    void cadastrarCandidato(String nome, String sobrenome, String email, String cep, String cidade, String estado, String pais,
                            String descricao, String senha, List<String> competencias, String cpf, LocalDate dataNascimento){

        def candidato = new Candidato(null, null, nome, sobrenome, email, cpf, dataNascimento, descricao, senha, competencias)

        def endereco = new Endereco(null, cep, cidade, estado, pais)

        candidatoDAO.insert(candidato, endereco)
        println "Candidato '$nome $sobrenome' cadastrado com sucesso!"
    }

    void listarCandidatos(){
        def candidatos = candidatoDAO.listarTodos()
        if (candidatos.isEmpty()){
            println "Nenhum candidato cadastrado."
            return
        }
        candidatos.each{ candidato ->
            candidato.exibirPerfil()
            println "\n"
        }
    }

    void buscarCandidato(Integer id){
        def candidato = candidatoDAO.select(id)
        if (!candidato){
            println "Candidato não encontrado."
            return
        }
        candidato.exibirPerfil()
    }

    void atualizarCandidato(Integer id, String nome, String sobrenome, String email, String cep, String cidade, String estado, String pais,
                            String descricao, String senha, List<String> competencias, String cpf, LocalDate dataNascimento){
        def candidato = candidatoDAO.select(id)
        if (!candidato){
            println "Candidato não encontrado."
            return
        }
        def atualizado = new Candidato(id, candidato.idEndereco, nome, sobrenome, email, cpf, dataNascimento, descricao, senha, competencias)
        def endereco = new Endereco(candidato.idEndereco, cep, cidade, estado, pais)
        candidatoDAO.update(atualizado, endereco)
        println "Candidato atualizado com sucesso!"
    }

    void deletarCandidato(Integer id){
        def candidato = candidatoDAO.select(id)
        if (!candidato){
            println "Candidato não encontrado."
            return
        }
        candidatoDAO.delete(id)
        println "Candidato deletado com sucesso!"
    }

}
