package com.c0d3m4513r.logger;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.val;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;

@Getter(onMethod_ = {@Pure})
@EqualsAndHashCode
@SuppressWarnings("deprecation")
public class JavaUtilLogger<T extends java.util.logging.Logger> implements LoggerDefaultLevels<T> {
    @SideEffectFree
    @SuppressWarnings("purity.not.sideeffectfree.assign.field")
    public JavaUtilLogger(@NonNull T logger) {
        this.logger = logger;
    }

    @NonNull
    T logger;

    @Override
    @Pure
    public boolean isLogLevelEnabled(LogLevel level) {
        return logger.isLoggable(getLevel(level));
    }

    @Override
    @Pure
    @SuppressWarnings("purity.not.deterministic.call")
    public @This @lombok.NonNull JavaUtilLogger<T> log(@NonNull LogLevel level, @NonNull String msg) {
        logger.log(getLevel(level),msg);
        return this;
    }

    @Override
    @Pure
    @SuppressWarnings("purity.not.deterministic.call")
    public @This @lombok.NonNull JavaUtilLogger<T> log(@NonNull LogLevel level, @NonNull String format, @NonNull Object arg) {
        logger.log(getLevel(level),format,arg);
        return this;
    }

    @Override
    @Pure
    @SuppressWarnings("purity.not.deterministic.call")
    public @This @lombok.NonNull JavaUtilLogger<T> log(@NonNull LogLevel level, @NonNull String format, @NonNull Object arg1, @NonNull Object arg2) {
        logger.log(getLevel(level),format,new Object[]{arg1, arg2});
        return this;
    }

    @Override
    @Pure
    @SuppressWarnings("purity.not.deterministic.call")
    public @This @lombok.NonNull JavaUtilLogger<T> log(@NonNull LogLevel level, @NonNull String format, @NonNull Object @NonNull ... arguments) {
        logger.log(getLevel(level),format,arguments);
        return this;

    }

    @Override
    @Pure
    @SuppressWarnings("purity.not.deterministic.call")
    public @This @lombok.NonNull JavaUtilLogger<T> log(@NonNull LogLevel level, @NonNull String msg, @NonNull Throwable t) {
        logger.log(getLevel(level),msg,t);
        return this;
    }

    @Override
    @Pure
    public @NonNull String getName() {
        val name = logger.getName();
        return name != null ? name : "";
    }


    @Pure
    private java.util.logging.Level getLevel(LogLevel level){
        switch (level){
            case Trace: return java.util.logging.Level.FINER;
            case Debug: return java.util.logging.Level.FINE;
            case Warn: return java.util.logging.Level.WARNING;
            case Error: return java.util.logging.Level.SEVERE;
            case Info:
            default: return java.util.logging.Level.INFO;
        }
    }
}
