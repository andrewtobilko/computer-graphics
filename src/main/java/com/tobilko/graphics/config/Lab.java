package com.tobilko.graphics.config;

/**
 *
 * Created by Andrew Tobilko on 18/09/16.
 *
 */
public interface Lab {

    default void perform() {
        throw new UnsupportedOperationException("I haven't got done yet!");
    }

}
