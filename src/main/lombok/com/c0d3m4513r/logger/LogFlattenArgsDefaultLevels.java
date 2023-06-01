package com.c0d3m4513r.logger;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.checkerframework.dataflow.qual.Pure;

/**
 * Default implementation of {@link Logger} that delegates all log statements accepting a default log level to the specific log level methods.
 * This class is only intended to be used in implement clauses. It is not recommended to use it as a type.
 * As such it was marked as deprecated, but just note that this is not for removal.
 */
@Deprecated
public interface LogFlattenArgsDefaultLevels<T> extends LoggerFlattenArgs<T>{
    /**
     * @see Logger#isTraceEnabled()
     */
    @Pure
    default boolean isTraceEnabled() {
        return isLogLevelEnabled(LogLevel.Trace);
    }

    /**
     * @see Logger#trace(String)
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> trace(@NonNull String msg) {
        return log(LogLevel.Trace, msg);
    }

    /**
     * Is the logger instance enabled for the DEBUG level?
     *
     * @return True if this Logger is enabled for the DEBUG level,
     * false otherwise.
     */
    @Pure
    default boolean isDebugEnabled() {
        return isLogLevelEnabled(LogLevel.Debug);
    }

    /**
     * Log a message at the DEBUG level.
     *
     * @param msg the message string to be logged
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> debug(@NonNull String msg) {
        return log(LogLevel.Debug, msg);
    }

    /**
     * Is the logger instance enabled for the INFO level?
     *
     * @return True if this Logger is enabled for the INFO level,
     * false otherwise.
     */
    @Pure
    default boolean isInfoEnabled() {
        return isLogLevelEnabled(LogLevel.Info);
    }

    /**
     * Log a message at the INFO level.
     *
     * @param msg the message string to be logged
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> info(@NonNull String msg) {
        return log(LogLevel.Info, msg);
    }

    /**
     * Is the logger instance enabled for the WARN level?
     *
     * @return True if this Logger is enabled for the WARN level,
     * false otherwise.
     */
    @Pure
    default boolean isWarnEnabled() {
        return isLogLevelEnabled(LogLevel.Warn);
    }

    /**
     * Log a message at the WARN level.
     *
     * @param msg the message string to be logged
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> warn(@NonNull String msg) {
        return log(LogLevel.Warn, msg);
    }

    /**
     * Is the logger instance enabled for the ERROR level?
     *
     * @return True if this Logger is enabled for the ERROR level,
     * false otherwise.
     */
    @Pure
    default boolean isErrorEnabled() {
        return isLogLevelEnabled(LogLevel.Error);
    }

    /**
     * Log a message at the ERROR level.
     *
     * @param msg the message string to be logged
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> error(@NonNull String msg) {
        return log(LogLevel.Error, msg);
    }
}
