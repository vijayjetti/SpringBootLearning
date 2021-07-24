package com.vijay.springbootlearning.logger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ThreadLocalContext {
    private static final ThreadLocal<LogContext> threadLocal = ThreadLocal.withInitial(LogContext::new);

    public static LogContext getLogContext() {
        return threadLocal.get();
    }

    public static void clean() {
        threadLocal.remove();
    }
}
