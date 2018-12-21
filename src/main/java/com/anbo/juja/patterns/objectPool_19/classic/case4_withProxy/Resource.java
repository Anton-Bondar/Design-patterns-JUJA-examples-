package com.anbo.juja.patterns.objectPool_19.classic.case4_withProxy;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
public interface Resource {
    // этот метод будет вызывать клиент у готового ресурса
    void doit(String data);

    // сам ресурс ничего не делает в этом методе
    void close();
}
