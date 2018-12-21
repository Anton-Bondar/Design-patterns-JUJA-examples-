package com.anbo.juja.patterns.objectPool_19.sample.simpleConnectionPool;

import org.junit.Test;
import org.mockito.InOrder;
import ua.com.juja.patterns.objectPool.classic.AbstractTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
public class ClientTest extends AbstractTest {

    @Test
    public void test() throws Exception {
        // given
        // мокаем коннекшен пул размером в 2
        ConnectionPool pool = mock(ConnectionPool.class);
        when(pool.getMaxCount()).thenReturn(2);

        // создаем клиента
        Client client = new Client(pool, true);

        // нам понадобится для работы клиента 4 конекшена
        Connection connection1 = mock(Connection.class);
        Connection connection21 = mock(Connection.class);
        Connection connection22 = mock(Connection.class);
        Connection connection3 = mock(Connection.class);
        // которые будут выдаваться в заданном порядке
        when(pool.get()).thenReturn(connection1, connection21, connection22, connection3);

        // там где коннекшены там и стейтменты
        PreparedStatement statement1 = mock(PreparedStatement.class);
        PreparedStatement statement21 = mock(PreparedStatement.class);
        PreparedStatement statement22 = mock(PreparedStatement.class);
        PreparedStatement statement3 = mock(PreparedStatement.class);
        // связаны они все один к одному
        // два из них для простых кверей, а два для параметризированных
        when(connection1.createStatement()).thenReturn(statement1);
        when(connection21.prepareStatement(anyString())).thenReturn(statement21);
        when(connection22.prepareStatement(anyString())).thenReturn(statement22);
        when(connection3.createStatement()).thenReturn(statement3);

        // последний стейтмент будет нам что-то возвращать
        ResultSet resultSet3 = mock(ResultSet.class);
        when(statement3.executeQuery(anyString())).thenReturn(resultSet3);

        // а вот что именно - указано тут
        when(resultSet3.next()).thenReturn(true, true, false);
        when(resultSet3.getInt(1)).thenReturn(0, 1);
        when(resultSet3.getString(2)).thenReturn("Data1", "Data2");

        // так вот mock-hell это когда мок на моке и моком погоняет
        // плохо если мок возвращает мок,
        // а тут у нас мок, который возвращает мок, который возвращает мок
        // который возвращает мок.
        // вроде как не сложно если вчитаться с первого раза,
        // но когда этот тест упадет - вот тогда понять почему упал - покажется адом
        // кроме того тест очень хрупкий и сильно привязан к реализации
        // я бы на проекте не писал такой тест, а тут его привел для науки
        // лучше написать чуть более интеграционный, чем такой хрупкий юнит
        // хрупкий (fragile) - часто ломающийся по разными причинам

        // when
        // делаем вызов на клиенте
        client.run(Arrays.asList("Data1", "Data2"));

        // then
        // тут проверяем два коннекшена и связанные с ними стейтменты
        // нам интересен порядок вызовов, но только для этих
        // потому что connection21 и connection22 со своими стейтментами
        // ранаются в отдельных потоках
        InOrder inOrder = inOrder(connection1, connection3,
                statement1, statement3);

        // создаем таблицу
        inOrder.verify(connection1).createStatement();
        inOrder.verify(statement1).executeUpdate("DROP TABLE IF EXISTS public.mytable;");
        inOrder.verify(statement1).executeUpdate("CREATE TABLE mytable (id integer, value text);");
        inOrder.verify(statement1).close();
        inOrder.verify(connection1).close();

        // вставляем первую строчку
        // вот тут второй поток, и потому свой inOrder
        InOrder inOrder21 = inOrder(connection21, statement21);
        inOrder21.verify(connection21).prepareStatement("INSERT INTO public.mytable (value) VALUES(?);");
        inOrder21.verify(statement21).setString(1, "Data1");
        inOrder21.verify(statement21).executeUpdate();
        inOrder21.verify(statement21).close();
        inOrder21.verify(connection21).close();

        // вставляем вторую строчку
        // а тут третий поток, и для него тоже свой inOrder
        InOrder inOrder22 = inOrder(connection22, statement22);
        inOrder22.verify(connection22).prepareStatement("INSERT INTO public.mytable (value) VALUES(?);");
        inOrder22.verify(statement22).setString(1, "Data2");
        inOrder22.verify(statement22).executeUpdate();
        inOrder22.verify(statement22).close();
        inOrder22.verify(connection22).close();

        // проверяем, что вывелось на экран
        // а это старый inorder в проверяющий коннекшены со стейтментами в main потоке
        inOrder.verify(connection3).createStatement();
        inOrder.verify(statement3).executeQuery("SELECT id, value FROM public.mytable;");
        inOrder.verify(statement3).close();
        inOrder.verify(connection3).close();

        // ну и финальное - что вывелось в консоль при этом
        String out = console.getOut();
        assertTrue(out.contains(
                "Create table START...\n" +
                "Create table DONE!\n"));
        assertTrue(out.contains("Update table with: Data1 START...\n"));
        assertTrue(out.contains("Update table with: Data2 START...\n"));
        assertTrue(out.contains("Update table with: Data1 DONE!\n"));
        assertTrue(out.contains("Update table with: Data2 DONE!\n"));
        assertTrue(out.contains(
                "Print data START...\n" +
                    "\t\t0 Data1\n" +
                    "\t\t1 Data2\n" +
                    "Print data DONE!\n"));
    }
}
