package com.example

import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.http.Context

class GreetingController(private val counterService: CounterService) {

    fun routes() {
        get("/greeting", ::greeting)
    }

    private fun greeting(ctx: Context) {
        val name = ctx.queryParam("name") ?: "World"
        ctx.json(Greeting(counterService.incrementAndGet(), "Hello, ${name}!"))
    }
}
