package com.example

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("greeting")
class GreetingController(private val counterService: CounterService) {

    @GetMapping
    fun greeting(request: HttpServletRequest, response: HttpServletResponse): Greeting {
        val name = request.getParameter("name") ?: "World"
        return Greeting(counterService.incrementAndGet(), "Hello, ${name}!")
    }
}
