package com.example

import org.springframework.stereotype.Component
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.ServerResponse.ok

@Component
class GreetingController(private val counterService: CounterService) {

    fun greeting(request: ServerRequest): ServerResponse {
        val name = request.param("name").orElse("World")
        return ok().body(Greeting(counterService.incrementAndGet(), "Hello, ${name}!"))
    }
}
