package com.anbo.juja.patterns.objectPool_19.classic;

import org.junit.Before;
import ua.com.juja.patterns.objectPool.ConsoleMock;
import ua.com.juja.patterns.objectPool.IdGenerator;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
public class AbstractTest {
    protected ConsoleMock console = new ConsoleMock();

    @Before
    public void setup() {
        IdGenerator.reset();
    }
}
