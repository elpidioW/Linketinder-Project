package org.example.service

import groovy.sql.Sql
import org.example.dao.VagaDAO
import org.example.model.Endereco
import org.example.model.Vaga

class VagaService {

    private VagaDAO vagaDAO

    VagaService(Sql sql) {
        this.vagaDAO = new VagaDAO(sql)
    }

    void cadastrarVaga(Integer idEmpresa, String nome, String descricao, String cep, String cidade, String estado, String pais, List<String> competencias) {
        def vaga = new Vaga(null, null, idEmpresa, nome, descricao, true, competencias)
        def endereco = new Endereco(null, cep, cidade, estado, pais)
        vagaDAO.insert(vaga, endereco)
        println "Vaga '$nome' cadastrada com sucesso!"
    }

    void listarVagas() {
        def vagas = vagaDAO.listarTodas()
        if (vagas.isEmpty()) {
            println "Nenhuma vaga cadastrada."
            return
        }
        vagas.each {vaga ->
            vaga.exibirVaga()
            println "\n"
        }
    }

    void buscarVaga(Integer id) {
        def vaga = vagaDAO.select(id)
        if (!vaga) {
            println "Vaga não encontrada."
            return
        }
        vaga.exibirVaga()
    }

    void atualizarVaga(Integer id, String nome, String descricao, Boolean ativa, String cep, String cidade, String estado, String pais, List<String> competencias) {
        def vaga = vagaDAO.select(id)
        if (!vaga) {
            println "Vaga não encontrada."
            return
        }
        def atualizada = new Vaga(id, vaga.idEndereco, vaga.idEmpresa, nome, descricao, ativa, competencias)
        def endereco = new Endereco(vaga.idEndereco, cep, cidade, estado, pais)
        vagaDAO.update(atualizada, endereco)
        println "Vaga atualizada com sucesso!"
    }

    void deletarVaga(Integer id) {
        def vaga = vagaDAO.select(id)
        if (!vaga) {
            println "Vaga não encontrada."
            return
        }
        vagaDAO.delete(id)
        println "Vaga deletada com sucesso!"
    }

}
