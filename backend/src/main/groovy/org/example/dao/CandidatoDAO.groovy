package org.example.dao

import groovy.sql.Sql
import org.example.model.Candidato
import org.example.model.Competencia
import org.example.model.Endereco

import javax.management.Query

class CandidatoDAO{

    private Sql sql
    private EnderecoDAO enderecoDAO
    private CompetenciaDAO competenciaDAO

    CandidatoDAO(Sql sql) {
        this.sql = sql
        this.enderecoDAO = new EnderecoDAO(sql)
        this.competenciaDAO = new CompetenciaDAO(sql)
    }


    Integer insert(Candidato candidato, Endereco endereco){
        Integer idEndereco = enderecoDAO.insert(endereco)

        def query = '''
            INSERT INTO candidato (nome, sobrenome, data_nascimento, email, cpf, descricao, senha, id_endereco)
            VALUES (:nome, :sobrenome, :dataNascimento, :email, :cpf, :descricao, :senha, :idEndereco)
        '''

        def keys = sql.executeInsert(query, [
                nome          : candidato.nome,
                sobrenome     : candidato.sobrenome,
                dataNascimento: candidato.dataNascimento,
                email         : candidato.email,
                cpf           : candidato.cpf,
                descricao     : candidato.descricao,
                senha         : candidato.senha,
                idEndereco    : idEndereco
        ])

        Integer idCandidato = keys[0][0] as Integer
        vincularCompetencias(idCandidato, candidato.competencias)
        return idCandidato
    }


    Candidato select(Integer id){
        def row = sql.firstRow('SELECT * FROM candidato WHERE id = :id', [id:id])

        if(!row)
            return null

        return new Candidato(row.id, row.id_endereco, row.nome, row.sobrenome, row.email, row.cpf,
                row.data_nascimento.toLocalDate(), row.descricao, row.senha, buscarCompetencias(row.id))
    }


    void update(Candidato candidato, Endereco endereco) {
        enderecoDAO.update(endereco)

        def query = '''
            UPDATE candidato
            SET nome           = :nome,
                sobrenome      = :sobrenome,
                data_nascimento = :dataNascimento,
                email          = :email,
                cpf            = :cpf,
                descricao      = :descricao,
                senha          = :senha
            WHERE id = :id
        '''

        sql.executeUpdate(query, [
                id            : candidato.id,
                nome          : candidato.nome,
                sobrenome     : candidato.sobrenome,
                dataNascimento: candidato.dataNascimento,
                email         : candidato.email,
                cpf           : candidato.cpf,
                descricao     : candidato.descricao,
                senha         : candidato.senha
        ])

        query = '''
            DELETE FROM candidato_competencia WHERE id_candidato = :id
        '''
        sql.execute(query, [id: candidato.id])

        vincularCompetencias(candidato.id, candidato.competencias)
    }

    Integer delete(Integer id){
        def query = '''
        DELETE FROM candidato 
            WHERE id = :id
    '''
        return sql.executeUpdate(query, [
                id: id
        ])
    }

    private List<String> buscarCompetencias(Integer idCandidato) {
        def query =
            '''
            SELECT comp.nome
            FROM competencia comp
            JOIN candidato_competencia cc ON cc.id_competencia = comp.id
            WHERE cc.id_candidato = :id
        '''
        return sql.rows(query, [id: idCandidato]).collect { it.nome }
    }


    private void vincularCompetencias(Integer idCandidato, List<String> competencias){
        competencias.each{ nomeComp ->
            def comp = competenciaDAO.buscarPorNome(nomeComp)


            if(!comp){
                Integer idNova = competenciaDAO.insert(new Competencia(nomeComp))
                comp = new Competencia(idNova, nomeComp)
            }


            def query = '''
                INSERT INTO candidato_competencia (id_candidato, id_competencia)
                VALUES (:idCandidato, :idCompetencia)
            '''
            sql.execute(query, [idCandidato: idCandidato, idCompetencia: comp.id])
        }
    }
}
