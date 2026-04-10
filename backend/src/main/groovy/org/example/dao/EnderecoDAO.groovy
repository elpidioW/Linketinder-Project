package org.example.dao

import groovy.sql.Sql
import org.example.model.Endereco

class EnderecoDAO {

    private Sql sql

    EnderecoDAO(Sql sql){
        this.sql = sql
    }

    Integer insert(Endereco endereco){
        def query = '''
            INSERT INTO endereco (cep, cidade, estado, pais)
            VALUES (:cep, :cidade, :estado, :pais)
        '''
        def keys = sql.executeInsert(query, [
                cep: endereco.cep,
                cidade: endereco.cidade,
                estado: endereco.estado,
                pais: endereco.pais
        ])
        return keys [0][0] as Integer
    }

    Endereco select(Integer id){
        def row = sql.firstRow('SELECT * FROM endereco WHERE id = :id', [id:id])
        if(!row)
            return null
        return new Endereco(row.id, row.cep, row.cidade, row.estado, row.pais)
    }

    Integer update(Endereco endereco){
        def query = '''
            UPDATE endereco 
            SET cep = :cep,
                cidade = :cidade,
                estado = :estado,
                pais = :pais
            WHERE id = :id
        '''

        return sql.executeUpdate(query, [
                id: endereco.id,
                cep: endereco.cep,
                cidade: endereco.cidade,
                estado: endereco.estado,
                pais: endereco.pais
        ])
    }

    Integer delete(Integer id){
        def query = '''
            DELETE FROM endereco 
                WHERE id = :id
        '''
        return sql.executeUpdate(query, [
                id: id
        ])
    }
}
