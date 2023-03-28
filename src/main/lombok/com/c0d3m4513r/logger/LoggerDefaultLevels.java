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
public interface LoggerDefaultLevels<T> extends Logger<T> {
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
     * Log a message at the TRACE level according to the specified format
     * and argument.
     *
     * <p>This form avoids superfluous object creation when the logger
     * is disabled for the TRACE level.
     *
     * @param format the format string
     * @param arg    the argument
     */
    @Pure
    @This
    @NonNull
    default @lombok.NonNull Logger<T> trace(@NonNull String format, @NonNull Object arg) {
        return log(LogLevel.Trace, format, arg);
    }

    /**
     * Log a message at the TRACE level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous object creation when the logger
     * is disabled for the TRACE level.
     *
     * @param format the format string
     * @param arg1   the first argument
     * @param arg2   the second argument
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> trace(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2) {
        return log(LogLevel.Trace, format, arg1, arg2);
    }

    /**
     * Log a message at the TRACE level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous string concatenation when the logger
     * is disabled for the TRACE level. However, this variant incurs the hidden
     * (and relatively small) cost of creating an <code>Object[]</code> before invoking the method,
     * even if this logger is disabled for TRACE. The variants taking {@link Logger#trace(String, Object) one} and
     * {@link Logger#trace(String, Object, Object) two} arguments exist solely in order to avoid this hidden cost.
     *
     * @param format    the format string
     * @param arguments a list of 3 or more arguments
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> trace(@NonNull String format, @NonNull Object @NonNull ... arguments) {
        return log(LogLevel.Trace, format, arguments);
    }

    /**
     * Log an exception (throwable) at the TRACE level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> trace(@NonNull String msg, @NonNull Throwable t) {
        return log(LogLevel.Trace, msg, t);
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
     * Log a message at the DEBUG level according to the specified format
     * and argument.
     *
     * <p>This form avoids superfluous object creation when the logger
     * is disabled for the DEBUG level.
     *
     * @param format the format string
     * @param arg    the argument
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> debug(@NonNull String format, @NonNull Object arg) {
        return log(LogLevel.Debug, format, arg);
    }

    /**
     * Log a message at the DEBUG level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous object creation when the logger
     * is disabled for the DEBUG level.
     *
     * @param format the format string
     * @param arg1   the first argument
     * @param arg2   the second argument
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> debug(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2) {
        return log(LogLevel.Debug, format, arg1, arg2);
    }

    /**
     * Log a message at the DEBUG level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous string concatenation when the logger
     * is disabled for the DEBUG level. However, this variant incurs the hidden
     * (and relatively small) cost of creating an <code>Object[]</code> before invoking the method,
     * even if this logger is disabled for DEBUG. The variants taking
     * {@link Logger#debug(String, Object) one} and {@link Logger#debug(String, Object, Object) two}
     * arguments exist solely in order to avoid this hidden cost.
     *
     * @param format    the format string
     * @param arguments a list of 3 or more arguments
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> debug(@NonNull String format, @NonNull Object @NonNull ... arguments) {
        return log(LogLevel.Debug, format, arguments);
    }

    /**
     * Log an exception (throwable) at the DEBUG level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> debug(@NonNull String msg, @NonNull Throwable t) {
        return log(LogLevel.Debug, msg, t);
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
     * Log a message at the INFO level according to the specified format
     * and argument.
     *
     * <p>This form avoids superfluous object creation when the logger
     * is disabled for the INFO level.
     *
     * @param format the format string
     * @param arg    the argument
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> info(@NonNull String format, @NonNull Object arg) {
        return log(LogLevel.Info, format, arg);
    }

    /**
     * Log a message at the INFO level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous object creation when the logger
     * is disabled for the INFO level.
     *
     * @param format the format string
     * @param arg1   the first argument
     * @param arg2   the second argument
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> info(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2) {
        return log(LogLevel.Info, format, arg1, arg2);
    }

    /**
     * Log a message at the INFO level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous string concatenation when the logger
     * is disabled for the INFO level. However, this variant incurs the hidden
     * (and relatively small) cost of creating an <code>Object[]</code> before invoking the method,
     * even if this logger is disabled for INFO. The variants taking
     * {@link #info(String, Object) one} and {@link #info(String, Object, Object) two}
     * arguments exist solely in order to avoid this hidden cost.
     *
     * @param format    the format string
     * @param arguments a list of 3 or more arguments
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> info(@NonNull String format, Object... arguments) {
        return log(LogLevel.Info, format, arguments);
    }

    /**
     * Log an exception (throwable) at the INFO level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> info(@NonNull String msg, @NonNull Throwable t) {
        return log(LogLevel.Info, msg, t);
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
     * Log a message at the WARN level according to the specified format
     * and argument.
     *
     * <p>This form avoids superfluous object creation when the logger
     * is disabled for the WARN level.
     *
     * @param format the format string
     * @param arg    the argument
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> warn(@NonNull String format, @NonNull Object arg) {
        return log(LogLevel.Warn, format, arg);
    }

    /**
     * Log a message at the WARN level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous string concatenation when the logger
     * is disabled for the WARN level. However, this variant incurs the hidden
     * (and relatively small) cost of creating an <code>Object[]</code> before invoking the method,
     * even if this logger is disabled for WARN. The variants taking
     * {@link #warn(String, Object) one} and {@link #warn(String, Object, Object) two}
     * arguments exist solely in order to avoid this hidden cost.
     *
     * @param format    the format string
     * @param arguments a list of 3 or more arguments
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> warn(@NonNull String format, Object... arguments) {
        return log(LogLevel.Warn, format, arguments);
    }

    /**
     * Log a message at the WARN level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous object creation when the logger
     * is disabled for the WARN level.
     *
     * @param format the format string
     * @param arg1   the first argument
     * @param arg2   the second argument
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> warn(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2) {
        return log(LogLevel.Warn, format, arg1, arg2);
    }

    /**
     * Log an exception (throwable) at the WARN level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> warn(@NonNull String msg, @NonNull Throwable t) {
        return log(LogLevel.Warn, msg, t);
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

    /**
     * Log a message at the ERROR level according to the specified format
     * and argument.
     *
     * <p>This form avoids superfluous object creation when the logger
     * is disabled for the ERROR level.
     *
     * @param format the format string
     * @param arg    the argument
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> error(@NonNull String format, @NonNull Object arg) {
        return log(LogLevel.Error, format, arg);
    }

    /**
     * Log a message at the ERROR level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous object creation when the logger
     * is disabled for the ERROR level.
     *
     * @param format the format string
     * @param arg1   the first argument
     * @param arg2   the second argument
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> error(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2) {
        return log(LogLevel.Error, format, arg1, arg2);
    }

    /**
     * Log a message at the ERROR level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous string concatenation when the logger
     * is disabled for the ERROR level. However, this variant incurs the hidden
     * (and relatively small) cost of creating an <code>Object[]</code> before invoking the method,
     * even if this logger is disabled for ERROR. The variants taking
     * {@link #error(String, Object) one} and {@link #error(String, Object, Object) two}
     * arguments exist solely in order to avoid this hidden cost.
     *
     * @param format    the format string
     * @param arguments a list of 3 or more arguments
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> error(@NonNull String format, Object... arguments) {
        return log(LogLevel.Error, format, arguments);
    }

    /**
     * Log an exception (throwable) at the ERROR level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    @Pure
    @This
    default @lombok.NonNull Logger<T> error(@NonNull String msg, @NonNull Throwable t) {
        return log(LogLevel.Error, msg, t);
    }
}
