package com.anbo.juja.patterns.objectPool_19.sample.simpleConnectionPool;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.UndeclaredThrowableException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
public class ConnectionPoolTest {

    private ConnectionPool pool;
    private Connection connection1;
    private Connection connection2;

    // подготовка (фикстура) для всех тестов одинаковая
    // один пул, два коннекшена
    @Before
    public void setup() {
        // мочим все :)
        ConnectionFactory factory = mock(ConnectionFactory.class);
        // коннекшена в пуле у нас два
        pool = new ConnectionPool(2, factory);

        connection1 = mock(Connection.class);
        connection2 = mock(Connection.class);
        // они будут возвращаться в заданном порядке
        when(factory.createConnection()).thenReturn(connection1, connection2);
    }

    // простой тест на проверку размера пула
    @Test
    public void testMaxPoolSize() throws SQLException {
        // when then
        assertEquals(2, pool.getMaxCount());
    }

    // простой тест но проверку что будет если будет exception
    // в каком-то методе connection
    @Test
    public void testExceptionInConnection() throws SQLException {
        // given
        doThrow(new SQLException("Очень все плохо!")).when(connection1).rollback();
        Connection connection = pool.get();

        // when then
        try {
            connection.rollback();
            fail("Expected exception");
        } catch (UndeclaredThrowableException e) {
            Throwable throwable = e.getUndeclaredThrowable();
            Throwable cause = throwable.getCause();
            assertEquals("Очень все плохо!", cause.getMessage());
        }

    }

    // тест на проверку того что вызов методов на прокси
    // приведет к вызову метода на оборачиваемом коннекшене
    @Test
    public void testCallMethodOnProxyCallItOnConnection_case1() throws SQLException {
        // when
        // берем первый и делаем на нем rollback (метод мог быть любым)
        Connection connectionProxy1 = pool.get();
        connectionProxy1.rollback();

        // then
        // проверяем что только на одном коннекшене был вызов rollback
        verify(connection1).rollback();
        verifyNoMoreInteractions(connection2);
    }

    // тот же тест, что и прошлый, только на другом объекте
    @Test
    public void testCallMethodOnProxyCallItOnConnection_case2() throws SQLException {
        // when
        // тут мы возьмем и второй проксик
        Connection connectionProxy1 = pool.get();
        Connection connectionProxy2 = pool.get();

        // when
        // и когда на нем сделаем вызов метода
        connectionProxy2.rollback();

        // then
        // то только на его коннекшене этот откликнется
        verifyNoMoreInteractions(connection1);
        verify(connection2).rollback();
    }

    // самый интересный тест - проверяет, что коннекшены возвращаются назад в пул
    // тут замешана магия многопоточности, держись!
    @Test
    public void testNoMoreMaxCountConnections() throws SQLException, ExecutionException, InterruptedException {
        // given
        // берем оба коннекшена
        Connection connectionProxy1 = pool.get();
        Connection connectionProxy2 = pool.get();

        // when
        // запускаем поток, который попробует взять третий кошшекшен
        // и на этом заблочится, потому что пул длинной в 2
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Connection> future = executor.submit(new Callable<Connection>() {
            @Override
            public Connection call() throws Exception {
                return pool.get();
            }
        });
        // заставим поток понервничать
        Thread.sleep(500);

        // then
        // мы проверим, что в future ничего пока нет
        // т.е. поток все еще ожидает своей очереди на pool.get()
        assertFalse(future.isDone());

        // when
        // "закрываем коннекшен" на проксике
        // но реальный коннекшен не закроется, а поместится обратно в пул
        connectionProxy1.close();

        // then
        // намекаем, что потоку пора завершаться
        // но он нас не послушает пока не разблочится на pool.get()
        executor.shutdown();
        // вот это мы и подождем сколько надобно
        // (эти две строчки работают в тандеме)
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

        // ура! внешний поток получил коннекшен и мы его получаем из future
        assertTrue(future.isDone());
        Connection connectionProxy3 = future.get();

        // when
        // ану-ка вызовем rollback на этом проксике?
        connectionProxy3.rollback();

        // then
        // так как первым вернулся назад в пул прокси представляющий connection1,
        // то его мы и вернули под видом третьего
        verify(connection1).rollback();
        // а второй ничего об этом и не узнал
        verifyNoMoreInteractions(connection2);
    }
}
