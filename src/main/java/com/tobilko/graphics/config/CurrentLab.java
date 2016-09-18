package com.tobilko.graphics.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * An interface-marker for specifying the current lab work to run up.
 *
 * Created by Andrew Tobilko on 18/09/16.
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentLab {}
