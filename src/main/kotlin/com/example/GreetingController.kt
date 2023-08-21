package com.example

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("greeting")
class GreetingController(private val counterService: CounterService) {

    @GetMapping
    fun greeting(
        @RequestParam(value = "name", defaultValue = "World") name: String
    ): Greeting {
        return Greeting(counterService.incrementAndGet(), "Hello, ${name}!")
    }
}
