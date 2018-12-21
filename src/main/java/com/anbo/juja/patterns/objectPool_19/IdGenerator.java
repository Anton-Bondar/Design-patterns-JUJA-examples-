package com.anbo.juja.patterns.objectPool_19;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oleksandr.baglai on 28.01.2016.
 */
// этот класс только в образовательных целях, дабы каждый новый Connection
// красиво печатались на экране с айдишечками: 1, 2, 3...
public class IdGenerator {

    private static Map<Object, String> ids = new HashMap<>();
    private static Integer ID = 0;

    public static String put(Object object) {
        String id = String.valueOf(++ID);
        ids.put(object, id);
        return id;
    }

    public static String get(Object object) {
        return ids.get(object);
    }

    public static void reset() {
        ID = 0;
    }
}
