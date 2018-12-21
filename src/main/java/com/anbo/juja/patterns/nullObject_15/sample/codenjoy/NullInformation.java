package com.anbo.juja.patterns.nullObject_15.sample.codenjoy;

import org.apache.commons.lang.StringUtils;

/**
 * Created by oleksandr.baglai on 10.12.2015.
 */
class NullInformation implements Information {

    NullInformation() {
        // do nothing
    }

    @Override
    public String getMessage() {
        // информация у нас всегда будет информативная -> ""
        return StringUtils.EMPTY;
    }
}
