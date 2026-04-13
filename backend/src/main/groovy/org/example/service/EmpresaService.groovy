package org.example.service

import groovy.sql.Sql
import org.example.dao.EmpresaDAO
import org.example.model.Empresa
import org.example.model.Endereco

class EmpresaService {

    private EmpresaDAO empresaDAO

    EmpresaService(Sql sql) {
        this.empresaDAO = new EmpresaDAO(sql)
    }

    void cadastrarEmpresa(String nome, String email, String cep, String cidade, String estado, String pais, String descricao, String senha, String cnpj){

        def empresa = new Empresa(null, null, nome, email, descricao, senha, cnpj)
        def endereco = new Endereco(null, cep, cidade, estado, pais)

        empresaDAO.insert(empresa, endereco)
        println "Empresa '$nome' cadastrada com sucesso!"
    }

    void listarEmpresas(){
        def empresas = empresaDAO.listarTodas()
        if (empresas.isEmpty()) {
            println "Nenhuma empresa cadastrada."
            return
        }
        empresas.each{ empresa ->
            empresa.exibirPerfil()
            println "\n"
        }
    }

    void buscarEmpresa(Integer id){
        def empresa = empresaDAO.select(id)
        if (!empresa){
            println "Empresa não encontrada."
            return
        }
        empresa.exibirPerfil()
    }

    void atualizarEmpresa(Integer id, String nome, String email, String cep, String cidade, String estado, String pais, String descricao, String senha, String cnpj){
        def empresa = empresaDAO.select(id)
        if (!empresa){
            println "Empresa não encontrada."
            return
        }
        def atualizada = new Empresa(id, empresa.idEndereco, nome, email, descricao, senha, cnpj)
        def endereco = new Endereco(empresa.idEndereco, cep, cidade, estado, pais)
        empresaDAO.update(atualizada, endereco)
        println "Empresa atualizada com sucesso!"
    }

    void deletarEmpresa(Integer id){
        def empresa = empresaDAO.select(id)
        if (!empresa){
            println "Empresa não encontrada."
            return
        }
        empresaDAO.delete(id)
        println "Empresa deletada com sucesso!"
    }
}
