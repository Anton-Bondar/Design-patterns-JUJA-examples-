package com.anbo.juja.patterns.objectPool_19.classic.case2_withFactory;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
// реализация фабричного метода
public class ObjectFactoryImpl implements ObjectFactory {

    @Override
    public Resource createResource() {
        // просто создает ресурс
        Resource resource = new Resource();

        System.out.println("create " + resource +  " from factory-method");
        return resource;
    }
}
