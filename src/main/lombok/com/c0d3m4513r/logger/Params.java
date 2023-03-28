package com.c0d3m4513r.logger;

import org.checkerframework.dataflow.qual.SideEffectFree;

/**
 * A class used internally to represent the different types of parameters that can be passed to a logger.
 */
public enum Params {
    None(),
    String(String.class),
    StringObject(String.class, Object.class),
    StringObjectObject(String.class, Object.class, Object.class),
    StringObjectArr(String.class, Object[].class),
    StringThrowable(String.class, Throwable.class);
    public final Class<?>[] clazz;

    @SideEffectFree
    @SuppressWarnings("purity.not.sideeffectfree.assign.field")
    Params(Class<?>... clazz) {
        this.clazz = clazz;
    }
}
