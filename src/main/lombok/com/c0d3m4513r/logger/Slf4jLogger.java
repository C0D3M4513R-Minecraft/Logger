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
public class Slf4jLogger<T extends org.slf4j.Logger> implements LoggerFlattenArgsDefaultLog<T> {
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
}
