package com.example

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class CounterService {

    @Value("#{new Integer('\${example.initial}')}")
    private val initial: Int? = null
    private val atomic: AtomicLong = AtomicLong((initial ?: 0).toLong())

    fun incrementAndGet(): Long {
        return atomic.incrementAndGet()
    }
}