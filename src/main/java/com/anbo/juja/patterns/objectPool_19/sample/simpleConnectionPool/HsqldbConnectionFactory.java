package com.anbo.juja.patterns.objectPool_19.sample.simpleConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
// фабричный метод генерирующий коннекшены к HSQLDB базе
// которая все сохранит в файле
public class HsqldbConnectionFactory implements ConnectionFactory {

    @Override
    public Connection createConnection() {
        try {
            System.out.println("\tCreate new connection!");

            Class.forName("org.hsqldb.jdbcDriver");

            return  DriverManager.getConnection(
                    "jdbc:hsqldb:file:src/main/resources/db/database.db", "SA", "");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
