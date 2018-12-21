package com.anbo.juja.patterns.objectPool_19.sample.simpleConnectionPool;

import java.sql.Connection;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
// абстракция фабричный метод
public interface ConnectionFactory {

    Connection createConnection();
}
