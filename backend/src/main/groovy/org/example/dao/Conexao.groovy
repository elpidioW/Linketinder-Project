package org.example.dao

import groovy.sql.Sql

class Conexao {

    static Sql getConnection() {
        def url = 'jdbc:postgresql://localhost:5432/teste'
        def user = 'postgres'
        def password = 'postgres'
        def driver = 'org.postgresql.Driver'

        return Sql.newInstance(url, user, password, driver)
    }
}