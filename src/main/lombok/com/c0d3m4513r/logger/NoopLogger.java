package com.c0d3m4513r.logger;

import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;

/**
 * This class should not be used.
 * It is a logger that does nothing.
 * As such to ensure that all types that are {@code instanceof} this class will do nothing, you cannot extend this.
 * If you really need a reference to this class, use {@link Logging#noopConfigLogger}.
 */
@NoArgsConstructor(onConstructor_ = @SideEffectFree)
final class NoopLogger implements LoggerDefaultLevels<Object>{
    @Override
    @Pure
    @NonNull
    public Object getLogger(){
        return true;
    }
    @Override
    @Pure
    public boolean isLogLevelEnabled(LogLevel level) {
        return false;
    }

    @Override
    @Pure
    public @This @lombok.NonNull NoopLogger log(@NonNull LogLevel level, @NonNull String msg) {
        return this;
    }

    @Override
    @Pure
    public @This @lombok.NonNull NoopLogger log(@NonNull LogLevel level, @NonNull String format, @NonNull Object arg) {
        return this;
    }

    @Override
    @Pure
    public @This @lombok.NonNull NoopLogger log(@NonNull LogLevel level, @NonNull String format, @NonNull Object arg1, @NonNull Object arg2) {
        return this;
    }

    @Override
    @Pure
    public @This @lombok.NonNull NoopLogger log(@NonNull LogLevel level, @NonNull String format, @NonNull Object @NonNull ... arguments) {
        return this;
    }

    @Override
    @Pure
    public @This @lombok.NonNull NoopLogger log(@NonNull LogLevel level, @NonNull String msg, @NonNull Throwable t) {
        return this;
    }

    @Override
    @Pure
    public @NonNull String getName() {
        return "NoopLogger";
    }
}
