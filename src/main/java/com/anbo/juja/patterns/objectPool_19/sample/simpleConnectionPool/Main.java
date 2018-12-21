package com.anbo.juja.patterns.objectPool_19.sample.simpleConnectionPool;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
// класс-запускатор
public class Main {

    public static void main(String[] args) throws Exception {
        // максимальное количество коннекшенов в пуле
        int maxCount = 2;

        // пример работает в двух режимах - для HSQLDB и PostgreSQL
        // отличия небольшие в SQL диалекте
        boolean isPostgreSQL = false;

        run(maxCount, isPostgreSQL);
    }

    public static void run(int maxCount, boolean isPostgreSQL) throws Exception {
        // так как у нас тут FactoryMethod то мы можем работать с различными
        // фабриками коннекшенов, обрати внимание на реализации
        ConnectionFactory factory = (isPostgreSQL)
                ? new PostgreSQLConnectionFactory()
                : new HsqldbConnectionFactory();

        // сам коннекшен пул, он будет содержать не болле двух коннекшенов
        // и конфигурируется фабрикой
        ConnectionPool pool = new ConnectionPool(maxCount, factory);

        // клиент, зависящий от пула коннекшенов
        Client client = new Client(pool, isPostgreSQL);

        // полезная работа совершаемая над клиентом
        List<String> data = new LinkedList<>();
        for (int index = 0; index < 10; index++) {
            data.add("Data" + index);
        }
        client.run(data);
    }
}
