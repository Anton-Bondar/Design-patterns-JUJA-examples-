package com.anbo.juja.patterns.objectPool_19.sample.simpleConnectionPool;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
public class HsqldbConnectionFactoryTest {

    @Test
    public void testCreateConnection() throws Exception {
        // given
        ConnectionFactory factory = new HsqldbConnectionFactory();

        // when
        Connection connection = factory.createConnection();

        // then
        assertEquals(org.hsqldb.jdbc.JDBCConnection.class,
                connection.getClass());
    }
}