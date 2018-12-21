package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

import java.io.IOException;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
// это абстракция для коммуникации с клиентом
public interface PlayerController {

    // тоже синглтончик (смотри Game.NULL - там объяснение)
    PlayerController NULL = new NullPlayerController();

    void requestControl(final Player player, final String board) throws IOException;

    void registerPlayerTransport(Player player, Joystick joystick);

    void unregisterPlayerTransport(Player player);
}
