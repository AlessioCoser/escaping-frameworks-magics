package com.example

import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class CounterService(props: Properties) {
    private val atomic = AtomicLong(props.exampleInitial.toLong())

    fun incrementAndGet(): Long {
        return atomic.incrementAndGet()
    }
}