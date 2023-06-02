package com.c0d3m4513r.logger;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * This converts a slf4j:1.7.15 or later Logger into a Logger compatible with the API.
 * Even if the slf4j library was relocated.
 *
 * @param <T> The slf4j Logger class
 */
@SuppressWarnings("deprecation")
@Value
@Getter(onMethod_ = {@Pure})
@AllArgsConstructor(onConstructor_ = {@SuppressWarnings("purity.not.sideeffectfree.assign.field"), @SideEffectFree})
public class Slf4jLoggerRelocatable<T> implements LoggerFlattenArgsDefaultLog<T> {
    @NonNull
    T logger;
    @NonNull
    Class<T> clazz;
    @NonNull
    String className;
    @NonNull
    @Getter(value = AccessLevel.PROTECTED, onMethod_ = {@Pure})
    private final static HashMap<String, Method> methods = new HashMap<>();


    /**
     * Creates a new Slf4jLoggerRelocatable
     * For the logger argument, it is assumed, that all methods in the slf4j-api:1.7.15 Logger interface are implemented and accessible,
     * but nevertheless {@link Method#setAccessible(boolean)} will be called to make accesses faster.
     * If the provided object does not implement all method that the slf4j-api:1.7.15 provides, any method may throw a {@link Slf4JImplError}.
     *
     * @param logger The slf4j logger
     * @param clazz  The interface of the logger (usually org.slf4j.Logger.class in source code,
     *               but due to relocation in modules it may be different in the compiled jar)
     *               This is used, to get the methods to call on the logger, and to cache all methods called.
     *               DO NOT RELY ON THE CACHING BEHAVIOR THOUGH. That is considered an implementation detail, and may change in Patch releases.
     */
    @SideEffectFree
    @SuppressWarnings("purity.not.sideeffectfree.assign.field")
    public Slf4jLoggerRelocatable(@NonNull T logger, @NonNull Class<T> clazz) {
        this.logger = logger;
        this.clazz = clazz;
        className = clazz.getName();
    }

    /**
     * Gets a method from the logger class.
     *
     * @param methodName Method name
     * @param params     The parameter types of that method
     * @return The method to the given name, parameter types and saved class
     * @throws Slf4JImplError if the supplied class or logger is not compatible with at least slf4j-api:1.7.15.
     */
    @Pure
    @SuppressWarnings({"purity.not.deterministic.catch", "purity.not.deterministic.not.sideeffectfree.call"})
    private Method getMethod(@NonNull final String methodName, @NonNull final Params params
    ) {
        final String key = className + "," + methodName + "," + params.name();
        Method method = methods.get(key);
        if (method == null) {
            try {
                method = clazz.getMethod(methodName, params.clazz);
            } catch (NoSuchMethodException | SecurityException e) {
                throw new Slf4JImplError(e);
            }
            try {
                method.setAccessible(true);
            } catch (Throwable e) {
                // ignore
            }
            methods.put(key, method);
        }
        return method;
    }

    /**
     * Invokes the specified method with the given parameters.
     *
     * @param methodName Method name to invoke
     * @param params     The parameter types of that method
     * @param parameters The parameter values of that method
     * @return The return value of the method
     * @throws Slf4JImplError if the supplied class or logger is not compatible with at least slf4j-api:1.7.15.
     */
    @Pure
    @SuppressWarnings({"purity.not.deterministic.not.sideeffectfree.call","purity.not.deterministic.catch"})
    //invoke is not sideeffect free because it could call a method that is not sideeffect free, but we do not do that here.
    @Nullable
    private Object invoke(@NonNull final String methodName,
                          @NonNull final Params params,
                          @NonNull final Object... parameters) {
        try {
            return getMethod(methodName, params).invoke(logger, parameters);
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException |
                 ExceptionInInitializerError e) {
            throw new Slf4JImplError(e);
        }
    }

    /**
     * @throws Slf4JImplError if the supplied class or logger is not compatible with at least slf4j-api:1.7.15.
     * @see org.slf4j.Logger#getName()
     */
    @Override
    public @NonNull String getName() {
        Object name = invoke("getName", Params.None);
        if (name instanceof String) {
            return (String) name;
        } else {
            return "Slf4jLoggerRelocatable";
        }
    }


    /**
     * @throws Slf4JImplError if the supplied class or logger is not compatible with at least slf4j-api:1.7.15.
     * @see org.slf4j.Logger#isTraceEnabled()
     */
    @Pure

    @Override
    public boolean isTraceEnabled() {
        final Object returnObject = invoke("isTraceEnabled", Params.None);
        if (returnObject instanceof Boolean) return (Boolean) returnObject;
        return false;
    }

    @Override
    @Pure
    public @NonNull T getLogger() {
        return logger;
    }

    /**
     * @throws Slf4JImplError if the supplied class or logger is not compatible with at least slf4j-api:1.7.15.
     * @see org.slf4j.Logger#trace(String)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLoggerRelocatable<T> trace(@NonNull String msg) {
        invoke("trace", Params.String, msg);
        return this;
    }

    /**
     * @throws Slf4JImplError if the supplied class or logger is not compatible with at least slf4j-api:1.7.15.
     * @see org.slf4j.Logger#isDebugEnabled()
     */
    @Pure

    @Override
    public boolean isDebugEnabled() {
        final Object returnObject = invoke("isDebugEnabled", Params.None);
        if (returnObject instanceof Boolean) return (Boolean) returnObject;
        return false;
    }

    /**
     * @throws Slf4JImplError if the supplied class or logger is not compatible with at least slf4j-api:1.7.15.
     * @see org.slf4j.Logger#debug(String)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLoggerRelocatable<T> debug(@NonNull String msg) {
        invoke("debug", Params.String, msg);
        return this;
    }

    /**
     * @throws Slf4JImplError if the supplied class or logger is not compatible with at least slf4j-api:1.7.15.
     * @see org.slf4j.Logger#isInfoEnabled()
     */
    @Pure

    @Override
    public boolean isInfoEnabled() {
        final Object returnObject = invoke("isInfoEnabled", Params.None);
        if (returnObject instanceof Boolean) return (Boolean) returnObject;
        return false;
    }

    /**
     * @throws Slf4JImplError if the supplied class or logger is not compatible with at least slf4j-api:1.7.15.
     * @see org.slf4j.Logger#info(String)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLoggerRelocatable<T> info(@NonNull String msg) {
        invoke("info", Params.String, msg);
        return this;
    }

    /**
     * @throws Slf4JImplError if the supplied class or logger is not compatible with at least slf4j-api:1.7.15.
     * @see org.slf4j.Logger#isWarnEnabled()
     */
    @Pure

    @Override
    public boolean isWarnEnabled() {
        final Object returnObject = invoke("isWarnEnabled", Params.None);
        if (returnObject instanceof Boolean) return (Boolean) returnObject;
        return false;
    }

    /**
     * @throws Slf4JImplError if the supplied class or logger is not compatible with at least slf4j-api:1.7.15.
     * @see org.slf4j.Logger#warn(String)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLoggerRelocatable<T> warn(@NonNull String msg) {
        invoke("warn", Params.String, msg);
        return this;
    }

    /**
     * @throws Slf4JImplError if the supplied class or logger is not compatible with at least slf4j-api:1.7.15.
     * @see org.slf4j.Logger#isErrorEnabled()
     */
    @Pure

    @Override
    public boolean isErrorEnabled() {
        final Object returnObject = invoke("isErrorEnabled", Params.None);
        if (returnObject instanceof Boolean) return (Boolean) returnObject;
        return false;
    }

    /**
     * @throws Slf4JImplError if the supplied class or logger is not compatible with at least slf4j-api:1.7.15.
     * @see org.slf4j.Logger#error(String)
     */
    @Pure

    @Override
    public @This @lombok.NonNull Slf4jLoggerRelocatable<T> error(@NonNull String msg) {
        invoke("error", Params.String, msg);
        return this;
    }
}
