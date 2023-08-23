package com.example

import org.springframework.web.servlet.function.RouterFunctionDsl
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.ServerResponse.ok

class GreetingController(private val counterService: CounterService) {

    fun routes(router: RouterFunctionDsl) {
        router.GET("/greeting", ::greeting)
    }

    private fun greeting(request: ServerRequest): ServerResponse {
        val name = request.param("name").orElse("World")
        return ok().body(Greeting(counterService.incrementAndGet(), "Hello, ${name}!"))
    }
}
