package com.anbo.juja.patterns.objectPool_19.sample.simpleConnectionPool;

import org.junit.Test;
import org.postgresql.util.PSQLException;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
public class PostgreSQLConnectionFactoryTest {

    @Test
    public void testCreateConnection() throws Exception {
        // given
        ConnectionFactory factory = new PostgreSQLConnectionFactory();

        try {
            // when
            Connection connection = factory.createConnection();

            // then
            assertEquals(org.postgresql.jdbc4.Jdbc4Connection.class,
                    connection.getClass());
        } catch (RuntimeException e) {
            // подключи PostgreSql сервер!
            Throwable cause = e.getCause();
            assertEquals(PSQLException.class, cause.getClass());
            assertEquals("Подсоединение отклонено. Проверьте что " +
                    "хост и порт указаны правильно и что postmaster " +
                    "принимает TCP/IP-подсоединения.", cause.getMessage());
        }
    }
}