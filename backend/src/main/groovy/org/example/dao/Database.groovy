package org.example.dao

import groovy.sql.Sql

class Database {

    static Sql getConnection() {
        def url = 'jdbc:postgresql://localhost:5432/linketinder'
        def user = 'postgres'
        def password = 'postgres'
        def driver = 'org.postgresql.Driver'

        return Sql.newInstance(url, user, password, driver)
    }
}