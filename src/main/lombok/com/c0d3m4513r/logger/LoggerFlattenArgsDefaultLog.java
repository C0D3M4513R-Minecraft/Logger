package com.c0d3m4513r.logger;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.checkerframework.dataflow.qual.Pure;

/**
 * Default implementation of {@link Logger} that delegates all log statements to the methods accepting a log level.
 * This class is only intended to be used in implement clauses. It is not recommended to use it as a type.
 * As such it was marked as deprecated, but just note that this is not for removal.
 */
@Deprecated
public interface LoggerFlattenArgsDefaultLog<T> extends LoggerFlattenArgs<T>{
    /**
     * Is the logger instance enabled for the specified level?
     *
     * @param level the level to log at
     * @return True if this Logger is enabled for the TRACE level,
     * false otherwise.
     */
    @Pure
    default boolean isLogLevelEnabled(LogLevel level){
        switch (level){
            case Trace:
                return isTraceEnabled();
            case Debug:
                return isDebugEnabled();
            case Info:
                return isInfoEnabled();
            case Warn:
                return isWarnEnabled();
            case Error:
                return isErrorEnabled();
            default:
                return false;
        }
    }

    /**
     * Log a message at the specified level.
     *
     * @param level the level to log at
     * @param msg   the message string to be logged
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> log(@NonNull LogLevel level, @NonNull String msg){
        switch (level){
            case Trace:
                if (isTraceEnabled()) return trace(msg);
                return this;
            case Debug:
                if (isDebugEnabled()) return debug(msg);
                return this;
            case Info:
                if (isInfoEnabled()) return info(msg);
                return this;
            case Warn:
                if (isWarnEnabled()) return warn(msg);
                return this;
            case Error:
                if (isErrorEnabled()) return error(msg);
            default:
                return this;
        }
    }
}
