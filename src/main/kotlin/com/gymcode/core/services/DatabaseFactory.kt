package com.gymcode.core.services

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {

    fun init(){
        Database.connect(hikari())
        databaseTransaction()
    }

    private fun hikari(): HikariDataSource{
        val config = HikariConfig()
        config.driverClassName = "com.mysql.jdbc.Driver"
        config.username = "root"
        config.password = "H@ppy123"
        config.jdbcUrl = "jdbc:mysql://localhost:3306/pakro-authentication"
        return HikariDataSource(config)
    }

    private fun databaseTransaction(){
        transaction {
            // database table creation goes here

        }
    }

}