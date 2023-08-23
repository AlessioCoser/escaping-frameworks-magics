package com.example

import java.util.concurrent.atomic.AtomicLong

class CounterService(initial: Long) {
    private val atomic = AtomicLong(initial)

    fun incrementAndGet(): Long {
        return atomic.incrementAndGet()
    }
}