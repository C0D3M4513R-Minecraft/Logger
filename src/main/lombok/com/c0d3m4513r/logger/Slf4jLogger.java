package com.c0d3m4513r.logger;

import lombok.Getter;
import lombok.Value;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.common.reflection.qual.ClassBound;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;

/**
 * This converts a slf4j:1.7.15 or later Logger into a Logger compatible with the API.
 * Note: if you relocate the slf4j api, this will not work. You will have to use Slf4jLoggerRelocated.
 *
 * @param <T> The slf4j Logger class
 */
@SuppressWarnings("deprecation")
@Value
@Getter(onMethod_ = {@Pure})
public class Slf4jLogger<T extends org.slf4j.Logger> implements LoggerDefaultLog<T> {
    @ClassBound("org.slf4j.Logger")
    @NonNull
    T logger;


    /**
     * Creates a new Slf4jLogger.
     * For the logger argument, it is assumed, that all methods in the slf4j-api:1.7.15 Logger interface are implemented and assessible.
     * If that is not the case, any method may throw random exceptions.
     *
     * @param logger The slf4j logger
     */
    @SideEffectFree
    @SuppressWarnings("purity.not.sideeffectfree.assign.field")
    public Slf4jLogger(@NonNull T logger) {
        this.logger = logger;
    }
    /**
     * @see org.slf4j.Logger#getName()
     */
    @Override
    @Pure
    public @NonNull String getName() {
        final String name = logger.getName();
        return name != null ? name : "";
    }


    /**
     * @see org.slf4j.Logger#isTraceEnabled()
     */
    @Pure
    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    /**
     * @see org.slf4j.Logger#trace(String)
     */
    @Pure
    @Override
    public @This @lombok.NonNull Slf4jLogger<T> trace(@NonNull String msg) {
        logger.trace(msg);
        return this;
    }

    /**
     * @see org.slf4j.Logger#trace(String, Object)
     */
    @Pure
    @Override
    public @This @lombok.NonNull Slf4jLogger<T> trace(@NonNull String format, @NonNull Object arg) {
        logger.trace(format, arg);
        return this;
    }

    /**
     * @see org.slf4j.Logger#trace(String, Object, Object)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> trace(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2) {
        logger.trace(format, arg1, arg2);
        return this;
    }

    /**
     * @see org.slf4j.Logger#trace(String, Object...)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> trace(@NonNull String format, @NonNull Object @NonNull ... arguments) {
        logger.trace(format, arguments);
        return this;
    }

    /**
     * @see org.slf4j.Logger#trace(String, Throwable)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> trace(@NonNull String msg, @NonNull Throwable t) {
        logger.trace(msg, t);
        return this;
    }

    /**
     * @see org.slf4j.Logger#isDebugEnabled()
     */
    @Pure

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    /**
     * @see org.slf4j.Logger#debug(String)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> debug(@NonNull String msg) {
        logger.debug(msg);
        return this;
    }

    /**
     * @see org.slf4j.Logger#debug(String, Object)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> debug(@NonNull String format, @NonNull Object arg) {
        logger.debug(format, arg);
        return this;
    }

    /**
     * @see org.slf4j.Logger#debug(String, Object, Object)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> debug(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2) {
        logger.debug(format, arg1, arg2);
        return this;
    }

    /**
     * @see org.slf4j.Logger#debug(String, Object...)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> debug(@NonNull String format, @NonNull Object @NonNull ... arguments) {
        logger.debug(format, arguments);
        return this;
    }

    /**
     * @see org.slf4j.Logger#debug(String, Throwable)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> debug(@NonNull String msg, @NonNull Throwable t) {
        logger.debug(msg, t);
        return this;
    }

    /**
     * @see org.slf4j.Logger#isInfoEnabled()
     */
    @Pure

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    /**
     * @see org.slf4j.Logger#info(String)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> info(@NonNull String msg) {
        logger.info(msg);
        return this;
    }

    /**
     * @see org.slf4j.Logger#info(String, Object)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> info(@NonNull String format, @NonNull Object arg) {
        logger.info(format, arg);
        return this;
    }

    /**
     * @see org.slf4j.Logger#info(String, Object, Object)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> info(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2) {
        logger.info(format, arg1, arg2);
        return this;
    }

    /**
     * @see org.slf4j.Logger#info(String, Object...)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> info(@NonNull String format, Object... arguments) {
        logger.info(format, arguments);
        return this;
    }

    /**
     * @see org.slf4j.Logger#info(String, Throwable)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> info(@NonNull String msg, @NonNull Throwable t) {
        logger.info(msg, t);
        return this;
    }

    /**
     * @see org.slf4j.Logger#isWarnEnabled()
     */
    @Pure

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    /**
     * @see org.slf4j.Logger#warn(String)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> warn(@NonNull String msg) {
        logger.warn(msg);
        return this;
    }

    /**
     * @see org.slf4j.Logger#warn(String, Object)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> warn(@NonNull String format, @NonNull Object arg) {
        logger.warn(format, arg);
        return this;
    }

    /**
     * @see org.slf4j.Logger#warn(String, Object...)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> warn(@NonNull String format, Object... arguments) {
        logger.warn(format, arguments);
        return this;
    }


    /**
     * @see org.slf4j.Logger#warn(String, Object, Object)
     */
    @Pure

    public @This @lombok.NonNull Slf4jLogger<T> warn(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2) {
        logger.warn(format, arg1, arg2);
        return this;
    }

    /**
     * @see org.slf4j.Logger#warn(String, Throwable)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> warn(@NonNull String msg, @NonNull Throwable t) {
        logger.warn(msg, t);
        return this;
    }

    /**
     * @see org.slf4j.Logger#isErrorEnabled()
     */
    @Pure

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    /**
     * @see org.slf4j.Logger#error(String)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> error(@NonNull String msg) {
        logger.error(msg);
        return this;
    }

    /**
     * @see org.slf4j.Logger#error(String, Object...)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> error(@NonNull String format, @NonNull Object arg) {
        logger.error(format, arg);
        return this;
    }

    /**
     * @see org.slf4j.Logger#error(String, Object, Object)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> error(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2) {
        logger.error(format, arg1, arg2);
        return this;
    }

    /**
     * @see org.slf4j.Logger#error(String, Object...)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> error(@NonNull String format, Object... arguments) {
        logger.error(format, arguments);
        return this;
    }

    /**
     * @see org.slf4j.Logger#error(String, Throwable)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLogger<T> error(@NonNull String msg, @NonNull Throwable t) {
        logger.error(msg, t);
        return this;
    }
}
