package com.anbo.juja.patterns.objectPool_19.sample.simpleConnectionPool;

import org.junit.Test;
import ua.com.juja.patterns.objectPool.classic.AbstractTest;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
public class MainTest extends AbstractTest {

    @Test
    public void test() throws Exception {
        // when
        // 1 коннекшен и на HSQLDB, иначе тест будет плясать
        Main.run(1, false);

        // then
        assertEquals("Create table START...\n" +
                "\tCreate new connection!\n" +
                "\tGet CONN1, opened = 1\n" +
                "\tPut CONN1, opened = 0\n" +
                "Create table DONE!\n" +
                "Update table with: Data0 START...\n" +
                "\tGet CONN1, opened = 1\n" +
                "\tPut CONN1, opened = 0\n" +
                "Update table with: Data0 DONE!\n" +
                "Update table with: Data1 START...\n" +
                "\tGet CONN1, opened = 1\n" +
                "\tPut CONN1, opened = 0\n" +
                "Update table with: Data1 DONE!\n" +
                "Update table with: Data2 START...\n" +
                "\tGet CONN1, opened = 1\n" +
                "\tPut CONN1, opened = 0\n" +
                "Update table with: Data2 DONE!\n" +
                "Update table with: Data3 START...\n" +
                "\tGet CONN1, opened = 1\n" +
                "\tPut CONN1, opened = 0\n" +
                "Update table with: Data3 DONE!\n" +
                "Update table with: Data4 START...\n" +
                "\tGet CONN1, opened = 1\n" +
                "\tPut CONN1, opened = 0\n" +
                "Update table with: Data4 DONE!\n" +
                "Update table with: Data5 START...\n" +
                "\tGet CONN1, opened = 1\n" +
                "\tPut CONN1, opened = 0\n" +
                "Update table with: Data5 DONE!\n" +
                "Update table with: Data6 START...\n" +
                "\tGet CONN1, opened = 1\n" +
                "\tPut CONN1, opened = 0\n" +
                "Update table with: Data6 DONE!\n" +
                "Update table with: Data7 START...\n" +
                "\tGet CONN1, opened = 1\n" +
                "\tPut CONN1, opened = 0\n" +
                "Update table with: Data7 DONE!\n" +
                "Update table with: Data8 START...\n" +
                "\tGet CONN1, opened = 1\n" +
                "\tPut CONN1, opened = 0\n" +
                "Update table with: Data8 DONE!\n" +
                "Update table with: Data9 START...\n" +
                "\tGet CONN1, opened = 1\n" +
                "\tPut CONN1, opened = 0\n" +
                "Update table with: Data9 DONE!\n" +
                "Print data START...\n" +
                "\tGet CONN1, opened = 1\n" +
                "\t\t0 Data0\n" +
                "\t\t1 Data1\n" +
                "\t\t2 Data2\n" +
                "\t\t3 Data3\n" +
                "\t\t4 Data4\n" +
                "\t\t5 Data5\n" +
                "\t\t6 Data6\n" +
                "\t\t7 Data7\n" +
                "\t\t8 Data8\n" +
                "\t\t9 Data9\n" +
                "\tPut CONN1, opened = 0\n" +
                "Print data DONE!\n", console.getOut());
    }
}
