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
public interface LoggerDefaultLog<T> extends Logger<T> {
    /**
     * Is the logger instance enabled for the specified level?
     *
     * @param level the level to log at
     * @return True if this Logger is enabled for the TRACE level,
     *         false otherwise.
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
     */
    @Pure
    default @This @lombok.NonNull Logger<T> log(@NonNull LogLevel level, @NonNull String msg){
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

    /**
     * Log a message at the specified level according to the specified format
     * and argument.
     *
     * <p>This form avoids superfluous object creation when the logger
     * is disabled for the specified level.
     *
     * @param level the level to log at
     * @param format the format string
     * @param arg    the argument
     */
    @Pure
    default @This @lombok.NonNull Logger<T> log(@NonNull LogLevel level, @NonNull String format, @NonNull Object arg){
        //noinspection DuplicatedCode
        switch (level){
            case Trace:
                if (isTraceEnabled()) return trace(format, arg);
                return this;
            case Debug:
                if (isDebugEnabled()) return debug(format, arg);
                return this;
            case Info:
                if (isInfoEnabled()) return info(format, arg);
                return this;
            case Warn:
                if (isWarnEnabled()) return warn(format, arg);
                return this;
            case Error:
                if (isErrorEnabled()) return error(format, arg);
            default:
                return this;
        }
    }

    /**
     * Log a message at the specified level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous object creation when the logger
     * is disabled for the specified level.
     *
     * @param level the level to log at
     * @param format the format string
     * @param arg1   the first argument
     * @param arg2   the second argument
     */
    @Pure
    default @This @lombok.NonNull Logger<T> log(@NonNull LogLevel level, @NonNull String format, @NonNull Object arg1, @NonNull Object arg2){
        switch (level){
            case Trace:
                if (isTraceEnabled()) return trace(format, arg1, arg2);
                return this;
            case Debug:
                if (isDebugEnabled()) return debug(format, arg1, arg2);
                return this;
            case Info:
                if (isInfoEnabled()) return info(format, arg1, arg2);
                return this;
            case Warn:
                if (isWarnEnabled()) return warn(format, arg1, arg2);
                return this;
            case Error:
                if (isErrorEnabled()) return error(format, arg1, arg2);
            default:
                return this;
        }
    }

    /**
     * Log a message at the specified level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous string concatenation when the logger
     * is disabled for the specified level. However, this variant incurs the hidden
     * (and relatively small) cost of creating an <code>Object[]</code> before invoking the method,
     * even if this logger is disabled for specified level. The variants taking {@link #log(LogLevel, String, Object) one} and
     * {@link #log(LogLevel, String, Object, Object) two} arguments exist solely in order to avoid this hidden cost.
     *
     * @param level the level to log at
     * @param format    the format string
     * @param arguments a list of 3 or more arguments
     */
    @Pure
    default @This @lombok.NonNull Logger<T> log(@NonNull LogLevel level, @NonNull String format, @NonNull Object... arguments){
        //noinspection DuplicatedCode
        switch (level){
            case Trace:
                if (isTraceEnabled()) return trace(format, arguments);
                return this;
            case Debug:
                if (isDebugEnabled()) return debug(format, arguments);
                return this;
            case Info:
                if (isInfoEnabled()) return info(format, arguments);
                return this;
            case Warn:
                if (isWarnEnabled()) return warn(format, arguments);
                return this;
            case Error:
                if (isErrorEnabled()) return error(format, arguments);
            default:
                return this;
        }
    }

    /**
     * Log an exception (throwable) at the specified level with an
     * accompanying message.
     *
     * @param level the level to log at
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    @Pure
    default @This @lombok.NonNull Logger<T> log(@NonNull LogLevel level, @NonNull String msg, @NonNull Throwable t){
        //noinspection DuplicatedCode
        switch (level){
            case Trace:
                if (isTraceEnabled()) return trace(msg, t);
                return this;
            case Debug:
                if (isDebugEnabled()) return debug(msg, t);
                return this;
            case Info:
                if (isInfoEnabled()) return info(msg, t);
                return this;
            case Warn:
                if (isWarnEnabled()) return warn(msg, t);
                return this;
            case Error:
                if (isErrorEnabled()) return error(msg, t);
            default:
                return this;
        }
    }
}
