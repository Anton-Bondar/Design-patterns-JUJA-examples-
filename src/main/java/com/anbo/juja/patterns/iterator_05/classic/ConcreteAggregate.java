package com.anbo.juja.patterns.iterator_05.classic;

/**
 * Created by oleksandr.baglai on 16.09.2015.
 */
public class ConcreteAggregate<T> implements Aggregate<T> {

    final Object[] array;

    public ConcreteAggregate(int count) {
        this.array = new Object[count];
    }

    public void set(int index, T value) {
        array[index] = value;
    }

    @Override
    public Iterator<T> createIterator() {
        return new ConcreteIterator<T>(this);
    }
}
