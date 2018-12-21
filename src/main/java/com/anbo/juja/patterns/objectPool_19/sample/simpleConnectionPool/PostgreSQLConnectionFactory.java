package com.anbo.juja.patterns.objectPool_19.sample.simpleConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
// фабричный метод генерирующий коннекшены к локальной базе PostgreSQL
// (на случай, если она у тебя стоит - создай там табличку pull)
public class PostgreSQLConnectionFactory implements ConnectionFactory {

    @Override
    public Connection createConnection() {
        try {
            System.out.println("\tCreate new connection!");

            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost/pull", "postgres", "postgres");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
