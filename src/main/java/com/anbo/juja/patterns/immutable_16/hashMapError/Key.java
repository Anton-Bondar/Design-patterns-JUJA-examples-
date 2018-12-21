package com.anbo.juja.patterns.immutable_16.hashMapError;

/**
 * Created by oleksandr.baglai on 21.12.2015.
 */
public class Key {

    private String data;

    public Key(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;

        return data.equals(key.data);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public String toString() {
        return data;
    }
}
