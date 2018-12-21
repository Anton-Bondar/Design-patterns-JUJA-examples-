package com.anbo.juja.patterns.iterator_05.sample;

/**
 * Created by oleksandr.baglai on 16.09.2015.
 */
public class Main {

    public static void main(String[] args) {
        List list = new ArrayList<String>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        printAggregate(list);

        Iterator iterator = list.iterator();
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.next();
        iterator.remove();

        printAggregate(list);
    }

    private static void printAggregate(Iterable iterable) {
        Iterator<String> iterator = iterable.iterator();

        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
        }

        System.out.println("-----");
    }
}
