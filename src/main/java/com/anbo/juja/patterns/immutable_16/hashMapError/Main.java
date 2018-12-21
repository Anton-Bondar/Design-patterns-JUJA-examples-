package com.anbo.juja.patterns.immutable_16.hashMapError;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oleksandr.baglai on 21.12.2015.
 */
public class Main {
    public static void main(String[] args) {
        // возьмем мапу
        Map<Key, Object> map = new HashMap<>();

        System.out.println("добавим в нее два объекта под разными ключами 'key1' и 'key2'");
        Key key1 = new Key("key1");
        Key key2 = new Key("key2");

        map.put(key1, "object1");
        map.put(key2, "object2");

        System.out.println("посмотрим, на месте ли объекты?");
        System.out.println(map.get(key1));
        System.out.println(map.get(key2));

        System.out.println("поменяем нечаянно один из ключей");
        key1.setData("key1_changed");

        System.out.println("а теперь, на месте ли объекты?");
        System.out.println(map.get(key1));
        System.out.println(map.get(key2));

        System.out.println("но мапа то все еще содержит два элемента!");
        System.out.println(map.size());

        System.out.println("но где же он? берем по старому ключу 'key1'");
        System.out.println(map.get(new Key("key1")));

        System.out.println("берем по новому ключу 'key1_changed'");
        System.out.println(map.get(new Key("key1_changed")));

        System.out.println("итерируемся по всей мапе");
        for (Map.Entry<Key, Object> entry : map.entrySet()) {
            System.out.println(entry.toString());
        }

        System.out.println("магия...");

        // вывод
        // добавим в нее два объекта под разными ключами 'key1' и 'key2'
        // посмотрим, на месте ли объекты?
        // object1
        // object2
        // поменяем нечаянно один из ключей
        // а теперь, на месте ли объекты?
        // null
        // object2
        // но мапа то все еще содержит два элемента!
        // 2
        // но где же он? берем по старому ключу 'key1'
        // null
        // берем по новому ключу 'key1_changed'
        // null
        // итерируемся по всей мапе
        // key2=object2
        // key1_changed=object1
        // магия...

        // ничего странного, если разобраться в том,
        // как устроена хэш-мапа внутри
        // http://habrahabr.ru/post/128017/
    }
}
