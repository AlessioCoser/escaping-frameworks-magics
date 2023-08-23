package com.example

import java.util.concurrent.atomic.AtomicLong

class CounterService(props: Properties) {
    private val atomic = AtomicLong(props.exampleInitial.toLong())

    fun incrementAndGet(): Long {
        return atomic.incrementAndGet()
    }
}