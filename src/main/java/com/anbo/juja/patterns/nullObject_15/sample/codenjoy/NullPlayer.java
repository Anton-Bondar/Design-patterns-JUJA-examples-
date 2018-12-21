package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

import org.apache.commons.lang.StringUtils;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
class NullPlayer extends Player {

    // зависим от всяких объектов? передадим null-объекты!
    NullPlayer() {
       super(StringUtils.EMPTY, GameType.NULL,
               PlayerScores.NULL, Information.NULL);
    }
}

