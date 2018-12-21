package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
// абстракция для выдаватора информации
// ну его реализация будет сообщать о чем-то
// вообще не важно что тут :)
public interface Information {

    // тоже синглтончик (смотри Game.NULL - там объяснение)
    Information NULL = new NullInformation();

    String getMessage();
}
