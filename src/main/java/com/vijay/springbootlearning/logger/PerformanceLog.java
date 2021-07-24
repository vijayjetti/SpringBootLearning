package com.vijay.springbootlearning.logger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PerformanceLog {
    public static LogContext getPerformanceLogContext() {
        return (LogContext) ThreadLocalContext.getLogContext().computeIfAbsent("Performance", s -> new LogContext());
    }
}
