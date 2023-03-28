package com.c0d3m4513r.logger;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.checkerframework.dataflow.qual.SideEffectFree;

//todo: see https://github.com/awhitford/lombok.maven/issues/163
@SuppressWarnings("type.anno.before.decl.anno")
public class Logging implements LoggerDefaultLevels<Object>{
    @SideEffectFree
    private Logging(){}
    public static final Logging INSTANCE = new Logging();
    public static final @NonNull NoopLogger noopConfigLogger = new NoopLogger();
    private static @NonNull Logger<?> configLogger = noopConfigLogger;

    public static void setConfigLogger(@Nullable Logger<?> configLogger) {
        if (configLogger == null || configLogger instanceof Logging) return;
        if (configLogger == noopConfigLogger) Logging.configLogger = configLogger;
    }

    @lombok.NonNull
    @Override
    //@checkerframwork.jank
    @SuppressWarnings("return") //incompatible return type? are you kidding me?
    public Object getLogger() {
        return configLogger.getLogger();
    }

    @Override
    public boolean isLogLevelEnabled(LogLevel level) {
        return configLogger.isLogLevelEnabled(level);
    }

    @Override
    public @This @NonNull @lombok.NonNull Logging log(@NonNull LogLevel level, @NonNull String msg) {
        configLogger.log(level, msg);
        return this;
    }

    @Override
    public @This @NonNull @lombok.NonNull Logging log(@NonNull LogLevel level, @NonNull String format, @NonNull Object arg) {
        configLogger.log(level, format, arg);
        return this;
    }

    @Override
    public @This @NonNull @lombok.NonNull Logging log(@NonNull LogLevel level, @NonNull String format, @NonNull Object arg1, @NonNull Object arg2) {
        configLogger.log(level, format, arg1, arg2);
        return this;
    }

    @Override
    public @This @NonNull @lombok.NonNull Logging log(@NonNull LogLevel level, @NonNull String format, @lombok.NonNull @NonNull Object... arguments) {
        configLogger.log(level, format, arguments);
        return this;
    }

    @Override
    public @This @NonNull @lombok.NonNull Logging log(@NonNull LogLevel level, @NonNull String msg, @NonNull Throwable t) {
        configLogger.log(level, msg, t);
        return this;
    }

    @Override
    public @NonNull String getName() {
        return configLogger.getName();
    }
}
