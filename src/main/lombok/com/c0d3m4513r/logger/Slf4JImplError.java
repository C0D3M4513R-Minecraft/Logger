package com.c0d3m4513r.logger;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.dataflow.qual.SideEffectFree;

/**
 * This class is used to consolidate errors that are thrown by the Slf4JImpl class.
 * Any obvious errors that are expected to be thrown by the Slf4JImpl class in case of wrong-usage will be wrapped in this class.
 */
@Value
@EqualsAndHashCode(callSuper = true)
public class Slf4JImplError extends RuntimeException {
    @NonNull
    Throwable cause;
    @SuppressWarnings({"purity.not.sideeffectfree.assign.field", "purity.not.sideeffectfree.call"})
    @SideEffectFree
    public Slf4JImplError(@NonNull Throwable cause) {
        super(cause);
        this.cause = cause;
    }
}
