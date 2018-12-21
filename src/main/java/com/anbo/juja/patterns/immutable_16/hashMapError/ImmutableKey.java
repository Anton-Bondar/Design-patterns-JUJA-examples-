package com.anbo.juja.patterns.immutable_16.hashMapError;

/**
 * Created by oleksandr.baglai on 21.12.2015.
 */
public final class ImmutableKey {

    private final String data;

    public ImmutableKey(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    // public void setData(String data) {
    //    this.data = data;
    // }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImmutableKey key = (ImmutableKey) o;

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
