package com.anbo.juja.patterns.objectPool_19.sample.simpleConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

// cпасибо за пример http://javatalks.ru/posts/68642
// с его помощью я заводил HSQLDB
public class SampleHsqldb {

    public static void main(String[] args) {
        // для запуска gui менеджера - раскоментировать эту стрчоку.
        // org.hsqldb.util.DatabaseManagerSwing.main(args);

        // подключаем драйвер
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Не удалось загрузить драйвер ДБ.");
            e.printStackTrace();
            System.exit(1);
        }

        // создаем коннекшен (база будет храниться в /src/main/resources/db/database.db)
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:hsqldb:file:src/main/resources/db/database.db", "SA", "");
        } catch (SQLException e) {
            System.err.println("Не удалось создать соединение.");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            // пересоздаем базу, если она была создана
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS mytable;");
            statement.executeUpdate("CREATE TABLE mytable (id IDENTITY, value VARCHAR(100));");

            // вставляем новые данные в нее
            statement.executeUpdate("INSERT INTO mytable (value) VALUES('Qwe');");
            statement.executeUpdate("INSERT INTO mytable (value) VALUES('Asd');");
            statement.executeUpdate("INSERT INTO mytable (value) VALUES('Zxc');");

            // читаем то, что добавили в таблицу
            ResultSet resultSet = statement.executeQuery("SELECT id, value FROM mytable;");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " "
                        + resultSet.getString(2));
            }

            // отключаемся от базы (специфическая команда HSQLDB)
            statement.execute("SHUTDOWN");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
