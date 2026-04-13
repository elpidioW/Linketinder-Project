package org.example.dao

import groovy.sql.Sql
import org.example.model.Empresa
import org.example.model.Endereco

class EmpresaDAO {
    private Sql sql
    private EnderecoDAO enderecoDAO


    EmpresaDAO(Sql sql){
        this.sql = sql
        this.enderecoDAO = new EnderecoDAO(sql)
    }


    Integer insert(Empresa empresa, Endereco endereco){
        Integer idEndereco = enderecoDAO.insert(endereco)

        def query = '''
            INSERT INTO empresa (nome, cnpj, email, descricao, senha, id_endereco)
            VALUES (:nome, :cnpj, :email, :descricao, :senha, :idEndereco)
        '''

        def keys = sql.executeInsert(query, [
                nome      : empresa.nome,
                cnpj      : empresa.cnpj,
                email     : empresa.email,
                descricao : empresa.descricao,
                senha     : empresa.senha,
                idEndereco: idEndereco
        ])

        return keys[0][0] as Integer
    }


    Empresa select(Integer id){
        def row = sql.firstRow('SELECT * FROM empresa WHERE id = :id', [id:id])

        if(!row)
            return null

        return new Empresa(row.id, row.id_endereco, row.nome, row.email, row.descricao, row.senha, row.cnpj)
    }

    List<Empresa> listarTodas() {
        def empresas = []
        sql.eachRow('SELECT * FROM empresa') { row ->
            empresas << new Empresa(row.id, row.id_endereco, row.nome, row.email, row.descricao, row.senha, row.cnpj)
        }
        return empresas
    }



    Integer update(Empresa empresa, Endereco endereco) {
        enderecoDAO.update(endereco)

        def query = '''
            UPDATE empresa
            SET nome      = :nome,
                cnpj      = :cnpj,
                email     = :email,
                descricao = :descricao,
                senha     = :senha
            WHERE id = :id
        '''


        return sql.executeUpdate(query, [
                id       : empresa.id,
                nome     : empresa.nome,
                cnpj     : empresa.cnpj,
                email    : empresa.email,
                descricao: empresa.descricao,
                senha    : empresa.senha
        ])
    }


    Integer delete(Integer id){
        def query = '''
        DELETE FROM empresa 
            WHERE id = :id
    '''
        return sql.executeUpdate(query, [
                id: id
        ])
    }

}