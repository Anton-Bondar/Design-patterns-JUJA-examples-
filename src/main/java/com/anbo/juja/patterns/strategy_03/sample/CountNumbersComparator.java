package com.anbo.juja.patterns.strategy_03.sample;

/**
 * Created by oleksandr.baglai on 03.09.2015.
 */
public class CountNumbersComparator implements Comparator {

    public boolean compare(Object o1, Object o2) {
        String s1 = o1.toString();
        String s2 = o2.toString();
        return (s1.length() - s1.replaceAll("[0-9]", "").length()) <
                (s2.length() - s2.replaceAll("[0-9]", "").length());
    }

}
