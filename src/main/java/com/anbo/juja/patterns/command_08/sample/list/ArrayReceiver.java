package com.anbo.juja.patterns.command_08.sample.list;

import java.util.Arrays;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
// наше хранилище, собственно массив
public class ArrayReceiver {

    // это мы храним
    private String[] array = new String[0];

    // а это разрешаем делать нашим клиентам

    public void copyOf(int newlength) {
        array = Arrays.copyOf(array, newlength);
    }

    public String get(int index) {
        return array[index];
    }

    public void set(int index, String data) {
        array[index] = data;
    }

    public int size() {
        return array.length;
    }
}
