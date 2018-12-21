package com.anbo.juja.patterns.objectPool_19.classic.case2_withFactory;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
// абстракция фабрики
public interface ObjectFactory {

    // содержащая один единственный метод для получения ресурса
    Resource createResource();
}
