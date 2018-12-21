package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

import java.io.IOException;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
class NullPlayerController implements PlayerController {

    // контроллер неуправляем

    NullPlayerController() {
        // do nothing
    }

    @Override
    public void requestControl(Player player, String board) throws IOException {
        // do nothing
    }

    @Override
    public void registerPlayerTransport(Player player, Joystick joystick) {
        // do nothing
    }

    @Override
    public void unregisterPlayerTransport(Player player) {
        // do nothing
    }
}
