package org.example.dao

import groovy.sql.Sql
import org.example.model.Competencia

class CompetenciaDAO {
    private Sql sql

    CompetenciaDAO(Sql sql) {
        this.sql = sql
    }

    Integer insert(Competencia competencia) {
        def query = '''
            INSERT INTO competencia (nome)
            VALUES (:nome)
            ON CONFLICT (NOME) DO NOTHING
        '''

        def keys = sql.executeInsert(query, [nome: competencia.nome])

        if (keys)
            return keys[0][0] as Integer


        def row = sql.firstRow('SELECT id FROM competencia WHERE nome = :nome', [nome: competencia.nome])


        return row.id as Integer
    }

    Competencia select(Integer id) {
        def row = sql.firstRow('SELECT * FROM competencia WHERE id = :id', [id: id])

        if (!row)
            return null

        return new Competencia(row.id, row.nome)
    }

    List<Competencia> listarTodas(){
        def competencias = []
        sql.eachRow('SELECT * FROM competencia ORDER BY nome') { row ->
            competencias << new Competencia(row.id, row.nome)
        }
        return competencias
    }

    Competencia buscarPorNome(String nome) {
        def row = sql.firstRow('SELECT * FROM competencia WHERE nome = :nome', [nome: nome])

        if (!row)
            return null

        return new Competencia(row.id, row.nome)
    }

    Integer update(Competencia competencia) {
        def query = '''
            UPDATE competencia
            SET nome = :nome
            WHERE id = :id
        '''

        return sql.executeUpdate(query, [
                id  : competencia.id,
                nome: competencia.nome
        ])
    }

    Integer delete(Integer id){
        def query = '''
            DELETE FROM competencia WHERE id = :id
            '''
        return sql.executeUpdate(query, [id: id])
    }
}