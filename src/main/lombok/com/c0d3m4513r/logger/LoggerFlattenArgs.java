package com.c0d3m4513r.logger;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.checkerframework.dataflow.qual.Pure;

/**
 * Default implementation of {@link Logger} that delegates all log statements accepting formatting arguments, to the ones that just accept a level and a Message.
 * This class is only intended to be used in implement clauses. It is not recommended to use it as a type.
 * As such it was marked as deprecated, but just note that this is not for removal.
 */
@Deprecated
public interface LoggerFlattenArgs<T> extends Logger<T>{
    /**
     * Log a message at the specified level according to the specified format
     * and argument.
     *
     * <p>This form avoids superfluous object creation when the logger
     * is disabled for the specified level.
     *
     * @param level  the level to log at
     * @param format the format string
     * @param arg    the argument
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> log(@NonNull LogLevel level, @NonNull String format, @NonNull Object arg){
        if (!isLogLevelEnabled(level)) return this;
        return log(
                level,
                format.replaceFirst("\\{}",arg.toString())
        );
    }

    /**
     * Log a message at the specified level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous object creation when the logger
     * is disabled for the specified level.
     *
     * @param level  the level to log at
     * @param format the format string
     * @param arg1   the first argument
     * @param arg2   the second argument
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> log(@NonNull LogLevel level, @NonNull String format, @NonNull Object arg1, @NonNull Object arg2){
        if (!isLogLevelEnabled(level)) return this;
        return log(
                level,
                format.replaceFirst("\\{}",arg1.toString())
                        .replaceFirst("\\{}",arg2.toString())
        );
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
     * @param level     the level to log at
     * @param format    the format string
     * @param arguments a list of 3 or more arguments
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> log(@NonNull LogLevel level, @NonNull String format, @NonNull Object... arguments){
        if (!isLogLevelEnabled(level)) return this;
        for (Object argument : arguments) {
            format = format.replaceFirst("\\{}", argument.toString());
        }
        return log(level, format);
    }

    /**
     * Log an exception (throwable) at the specified level with an
     * accompanying message.
     *
     * @param level the level to log at
     * @param msg   the message accompanying the exception
     * @param t     the exception (throwable) to log
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> log(@NonNull LogLevel level, @NonNull String msg, @NonNull Throwable t){
        if (!isLogLevelEnabled(level)) return this;
        return log(level, msg + ThrowableUtils.toStringWithStacktrace(t));
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
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> trace(@NonNull String format, @NonNull Object arg){
        if (!isTraceEnabled()) return this;
        return trace(format.replaceFirst("\\{}", arg.toString()));
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
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> trace(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2){
        if (!isTraceEnabled()) return this;
        return trace(
                format.replaceFirst("\\{}", arg1.toString())
                        .replaceFirst("\\{}", arg2.toString())
        );
    }

    /**
     * Log a message at the TRACE level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous string concatenation when the logger
     * is disabled for the TRACE level. However, this variant incurs the hidden
     * (and relatively small) cost of creating an <code>Object[]</code> before invoking the method,
     * even if this logger is disabled for TRACE. The variants taking {@link #trace(String, Object) one} and
     * {@link #trace(String, Object, Object) two} arguments exist solely in order to avoid this hidden cost.
     *
     * @param format    the format string
     * @param arguments a list of 3 or more arguments
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> trace(@NonNull String format, @NonNull Object... arguments){
        if (!isTraceEnabled()) return this;
        for (Object argument : arguments) {
            trace(argument.toString());
        }
        return trace(format);
    }

    /**
     * Log an exception (throwable) at the TRACE level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> trace(@NonNull String msg, @NonNull Throwable t){
        if (!isTraceEnabled()) return this;
        return trace(msg+ThrowableUtils.toStringWithStacktrace(t));
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
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> debug(@NonNull String format, @NonNull Object arg){
            if (!isDebugEnabled()) return this;
            return debug(format.replaceFirst("\\{}",arg.toString()));
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
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> debug(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2){
        if (!isDebugEnabled()) return this;
        return debug(
                format.replaceFirst("\\{}",arg1.toString())
                        .replaceFirst("\\{}",arg2.toString())
        );
    }

    /**
     * Log a message at the DEBUG level according to the specified format
     * and arguments.
     *
     * <p>This form avoids superfluous string concatenation when the logger
     * is disabled for the DEBUG level. However, this variant incurs the hidden
     * (and relatively small) cost of creating an <code>Object[]</code> before invoking the method,
     * even if this logger is disabled for DEBUG. The variants taking
     * {@link #debug(String, Object) one} and {@link #debug(String, Object, Object) two}
     * arguments exist solely in order to avoid this hidden cost.
     *
     * @param format    the format string
     * @param arguments a list of 3 or more arguments
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> debug(@NonNull String format, @NonNull Object... arguments){
        if (!isDebugEnabled()) return this;
        for (Object argument : arguments) {
            format = format.replaceFirst("\\{}", argument.toString());
        }
        return debug(format);
    }

    /**
     * Log an exception (throwable) at the DEBUG level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> debug(@NonNull String msg, @NonNull Throwable t){
        if (!isDebugEnabled()) return this;
        return debug(msg+ThrowableUtils.toStringWithStacktrace(t));
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
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> info(@NonNull String format, @NonNull Object arg){
            if (!isInfoEnabled()) return this;
            return info(format.replaceFirst("\\{}",arg.toString()));
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
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> info(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2){
        if (!isInfoEnabled()) return this;
        return info(
                format.replaceFirst("\\{}",arg1.toString())
                        .replaceFirst("\\{}",arg2.toString())
        );
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
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> info(@NonNull String format, @NonNull Object... arguments){
        if (!isInfoEnabled()) return this;
        for (Object argument : arguments) {
            format = format.replaceFirst("\\{}", argument.toString());
        }
        return info(format);
    }
    /**
     * Log an exception (throwable) at the INFO level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> info(@NonNull String msg, @NonNull Throwable t){
        if (!isInfoEnabled()) return this;
        return info(msg+ThrowableUtils.toStringWithStacktrace(t));
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
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> warn(@NonNull String format, @NonNull Object arg){
        if (!isWarnEnabled()) return this;
        return warn(format.replaceFirst("\\{}",arg.toString()));
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
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> warn(@NonNull String format, @NonNull Object... arguments){
        if (!isWarnEnabled()) return this;
        for (Object argument : arguments) {
            format = format.replaceFirst("\\{}", argument.toString());
        }
        return warn(format);
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
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> warn(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2){
        if (!isWarnEnabled()) return this;
        return warn(
                format.replaceFirst("\\{}", arg1.toString())
                        .replaceFirst("\\{}", arg2.toString())
        );
    }

    /**
     * Log an exception (throwable) at the WARN level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> warn(@NonNull String msg, @NonNull Throwable t){
        if (!isWarnEnabled()) return this;
        return warn(msg+ThrowableUtils.toStringWithStacktrace(t));
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
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> error(@NonNull String format, @NonNull Object arg){
        if (!isErrorEnabled()) return this;
        return error(format.replaceFirst("\\{}",arg.toString()));
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
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> error(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2){
        if (!isErrorEnabled()) return this;
        return error(
                format.replaceFirst("\\{}",arg1.toString())
                        .replaceFirst("\\{}", arg2.toString())
        );
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
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> error(@NonNull String format, @NonNull Object... arguments){
        if (!isErrorEnabled()) return this;
        for (Object argument : arguments) {
            format = format.replaceFirst("\\{}", argument.toString());
        }
        return error(format);
    }

    /**
     * Log an exception (throwable) at the ERROR level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     * @return this
     */
    @Pure
    @This
    @NonNull
    default Logger<T> error(@NonNull String msg, @NonNull Throwable t){
        if (!isErrorEnabled()) return this;
        return error(msg+ThrowableUtils.toStringWithStacktrace(t));
    }
}
