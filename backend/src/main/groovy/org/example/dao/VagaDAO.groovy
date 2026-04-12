package org.example.dao

import groovy.sql.Sql
import org.example.model.Competencia
import org.example.model.Vaga
import org.example.model.Endereco

class VagaDAO {
    private Sql sql
    private EnderecoDAO enderecoDAO
    private CompetenciaDAO competenciaDAO

    VagaDAO(Sql sql) {
        this.sql = sql
        this.enderecoDAO = new EnderecoDAO(sql)
        this.competenciaDAO = new CompetenciaDAO(sql)
    }

    Integer insert(Vaga vaga, Endereco endereco){
        Integer idEndereco = enderecoDAO.insert(endereco)


        def query = '''
            INSERT INTO vaga (nome, descricao, ativa, id_endereco, id_empresa)
            VALUES (:nome, :descricao, :ativa, :idEndereco, :idEmpresa)            
            '''

        def keys = sql.executeInsert(query, [
                nome: vaga.nome,
                descricao: vaga.descricao,
                ativa: vaga.ativa,
                idEndereco: idEndereco,
                idEmpresa: vaga.idEmpresa
        ])

        Integer idVaga = keys[0][0] as Integer
        vincularCompetencias(idVaga, vaga.competencias)
        return idVaga
    }


    Vaga select(Integer id){
        def row = sql.firstRow('SELECT * FROM vaga WHERE id = :id', [id:id])

        if(!row)
            return null

        return new Vaga(row.id, row.id_endereco, row.id_empresa, row.nome, row.descricao, row.ativa, buscarCompetencias(row.id))
    }


    List<Vaga> listarVagasAtivasPorEmpresa(Integer idEmpresa) {
        def vagas = []

        def query = '''
            SELECT *
            FROM vaga
            WHERE ativa = true
            AND id_empresa = :idEmpresa
        '''

        sql.eachRow(query, [idEmpresa: idEmpresa]){ row ->
            vagas << new Vaga(row.id, row.id_endereco, row.id_empresa, row.nome, row.descricao, row.ativa, buscarCompetencias(row.id))
        }
        return vagas
    }

    void update(Vaga vaga, Endereco endereco) {
        enderecoDAO.update(endereco)

        def query = '''
            UPDATE vaga
            SET nome      = :nome,
                descricao = :descricao,
                ativa     = :ativa
            WHERE id = :id
        '''

        sql.executeUpdate(query, [
                id: vaga.id,
                nome: vaga.nome,
                descricao: vaga.descricao,
                ativa: vaga.ativa
        ])

        query = '''
            DELETE FROM vaga_competencia WHERE id_vaga = :id
        '''

        def qtdAlterada = sql.executeUpdate(query, [id: vaga.id])

        vincularCompetencias(vaga.id, vaga.competencias)
    }

    Integer delete(Integer id){
        def query = '''
        DELETE FROM vaga 
            WHERE id = :id
    '''
        return sql.executeUpdate(query, [
                id: id
        ])
    }

     List<String> buscarCompetencias(Integer idVaga) {
        def query =
                '''
            SELECT comp.nome
            FROM competencia comp
            JOIN vaga_competencia vc ON vc.id_competencia = comp.id
            WHERE vc.id_vaga = :id
        '''
        return sql.rows(query, [id: idVaga]).collect { it.nome }
    }



     void vincularCompetencias(Integer idVaga, List<String> competencias){
        competencias.each{ nomeComp ->
            def comp = competenciaDAO.buscarPorNome(nomeComp)

            if(!comp){
                Integer idNova = competenciaDAO.insert(new Competencia(nomeComp))
                comp = new Competencia(idNova, nomeComp)
            }

            def query = '''
                INSERT INTO vaga_competencia (id_vaga, id_competencia)
                VALUES (:idVaga, :idCompetencia)
            '''
            sql.execute(query, [idVaga: idVaga, idCompetencia: comp.id])
        }
    }
}