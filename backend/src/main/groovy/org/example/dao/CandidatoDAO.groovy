package org.example.dao

import groovy.sql.Sql

class CandidatoDAO {

    private Sql sql

    CandidatoDAO(Sql sql){
        this.sql = sql
    }
}
