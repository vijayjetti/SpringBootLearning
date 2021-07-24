package com.vijay.springbootlearning.logger;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

@Slf4j
public class LogContext {

    private final ConcurrentMap<String, Object> map;

    public LogContext(@NotNull ConcurrentMap<String, Object> map) {
        this.map = map;
    }

    public LogContext(@NotNull Map<String, Long> map) {
        this.map = new ConcurrentHashMap<>(map);
    }

    public LogContext() {
        this.map = new ConcurrentHashMap<>();
    }

    public boolean exists(@NotNull String key) {
        checkBlank(key);
        return map.containsKey(key);
    }

    public Object get(@NotNull String key) {
        checkBlank(key);
        return map.get(key);
    }

    public Object put(@NotNull String key, @NotNull Object value) {
        checkBlank(key);
        checkBlank(String.valueOf(value));
        return map.put(key, value);
    }
    public int size() {
        return map.size();
    }

    public Object computeIfAbsent(@NotNull String key, @NotNull Function<String, Object> function) {
        checkBlank(key);
        /** Singleton Design pattern**/
        Object logContext = map.get(key);
        if (logContext == null) {
            synchronized (LogContext.class) {
                logContext = map.get(key);
                if (logContext == null) {
                    logContext = function.apply(key);
                    map.put(key, logContext);
                }
            }
        }
        return logContext;
    }

    private void checkBlank(String key) {
        if (StringUtils.isBlank(key)) throw new IllegalArgumentException(String.format("Performance %s shouldn't be null", key));
    }
}
