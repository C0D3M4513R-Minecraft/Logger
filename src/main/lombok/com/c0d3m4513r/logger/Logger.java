package com.c0d3m4513r.logger;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.checkerframework.dataflow.qual.Pure;

/**
 * Copyright (c) 2004-2022 QOS.ch
 * All rights reserved.
 * <p>
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 * <p>
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 * <p>
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
//todo: https://github.com/awhitford/lombok.maven/issues/163
@SuppressWarnings("type.anno.before.decl.anno")
public interface Logger<T> {
    @Pure
    @NonNull
    T getLogger();

    /**
     * Is the logger instance enabled for the specified level?
     *
     * @param level the level to log at
     * @return True if this Logger is enabled for the TRACE level,
     * false otherwise.
     */
    @Pure
    boolean isLogLevelEnabled(LogLevel level);

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
    Logger<T> log(@NonNull LogLevel level, @NonNull String msg);

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
    Logger<T> log(@NonNull LogLevel level, @NonNull String format, @NonNull Object arg);

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
    Logger<T> log(@NonNull LogLevel level, @NonNull String format, @NonNull Object arg1, @NonNull Object arg2);

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
    Logger<T> log(@NonNull LogLevel level, @NonNull String format, @NonNull Object... arguments);

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
    Logger<T> log(@NonNull LogLevel level, @NonNull String msg, @NonNull Throwable t);

    /**
     * Return the name of this <code>Logger</code> instance.
     *
     * @return name of this logger instance
     */
    @NonNull
    @Pure
    String getName();

    /**
     * Is the logger instance enabled for the TRACE level?
     *
     * @return True if this Logger is enabled for the TRACE level,
     * false otherwise.
     */
    @Pure
    boolean isTraceEnabled();

    /**
     * Log a message at the TRACE level.
     *
     * @param msg the message string to be logged
     * @return this
     */
    @Pure
    @This
    @NonNull
    Logger<T> trace(@NonNull String msg);

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
    Logger<T> trace(@NonNull String format, @NonNull Object arg);

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
    Logger<T> trace(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2);

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
    Logger<T> trace(@NonNull String format, @NonNull Object... arguments);

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
    Logger<T> trace(@NonNull String msg, @NonNull Throwable t);

    /**
     * Is the logger instance enabled for the DEBUG level?
     *
     * @return True if this Logger is enabled for the DEBUG level,
     * false otherwise.
     */
    @Pure
    boolean isDebugEnabled();

    /**
     * Log a message at the DEBUG level.
     *
     * @param msg the message string to be logged
     * @return this
     */
    @Pure
    @This
    @NonNull
    Logger<T> debug(@NonNull String msg);

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
    Logger<T> debug(@NonNull String format, @NonNull Object arg);

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
    Logger<T> debug(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2);

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
    Logger<T> debug(@NonNull String format, @NonNull Object... arguments);

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
    Logger<T> debug(@NonNull String msg, @NonNull Throwable t);

    /**
     * Is the logger instance enabled for the INFO level?
     *
     * @return True if this Logger is enabled for the INFO level,
     * false otherwise.
     */
    @Pure
    boolean isInfoEnabled();

    /**
     * Log a message at the INFO level.
     *
     * @param msg the message string to be logged
     * @return this
     */
    @Pure
    @This
    @NonNull
    Logger<T> info(@NonNull String msg);

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
    Logger<T> info(@NonNull String format, @NonNull Object arg);

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
    Logger<T> info(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2);

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
    Logger<T> info(@NonNull String format, @NonNull Object... arguments);

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
    Logger<T> info(@NonNull String msg, @NonNull Throwable t);

    /**
     * Is the logger instance enabled for the WARN level?
     *
     * @return True if this Logger is enabled for the WARN level,
     * false otherwise.
     */
    @Pure
    boolean isWarnEnabled();

    /**
     * Log a message at the WARN level.
     *
     * @param msg the message string to be logged
     * @return this
     */
    @Pure
    @This
    @NonNull
    Logger<T> warn(@NonNull String msg);

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
    Logger<T> warn(@NonNull String format, @NonNull Object arg);

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
    Logger<T> warn(@NonNull String format, @NonNull Object... arguments);

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
    Logger<T> warn(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2);

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
    Logger<T> warn(@NonNull String msg, @NonNull Throwable t);

    /**
     * Is the logger instance enabled for the ERROR level?
     *
     * @return True if this Logger is enabled for the ERROR level,
     * false otherwise.
     */
    @Pure
    boolean isErrorEnabled();

    /**
     * Log a message at the ERROR level.
     *
     * @param msg the message string to be logged
     * @return this
     */
    @Pure
    @This
    @NonNull
    Logger<T> error(@NonNull String msg);

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
    Logger<T> error(@NonNull String format, @NonNull Object arg);

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
    Logger<T> error(@NonNull String format, @NonNull Object arg1, @NonNull Object arg2);

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
    Logger<T> error(@NonNull String format, @NonNull Object... arguments);

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
    Logger<T> error(@NonNull String msg, @NonNull Throwable t);

}
