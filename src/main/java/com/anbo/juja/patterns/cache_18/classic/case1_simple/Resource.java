package com.anbo.juja.patterns.cache_18.classic.case1_simple;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
// ресурс с идентификатором
public class Resource {
    private int id;

    public Resource(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Resource:" + id;
    }
}
