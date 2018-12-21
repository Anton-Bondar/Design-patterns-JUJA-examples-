package com.anbo.juja.patterns.strategy_03.sample;

/**
 * Created by oleksandr.baglai on 10.08.2015.
 */
public class ToStringLengthComparator implements Comparator {

    @Override
    public boolean compare(Object o1, Object o2) {
        return o1.toString().length() > o2.toString().length();
    }
}
