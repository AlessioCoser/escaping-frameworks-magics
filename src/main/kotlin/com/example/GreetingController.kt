package com.example

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("greeting")
class GreetingController(private val counterService: CounterService) {

    @GetMapping
    fun greeting(request: HttpServletRequest, response: HttpServletResponse): ResponseEntity<Greeting> {
        val name = request.getParameter("name") ?: "World"
        return ok().body(Greeting(counterService.incrementAndGet(), "Hello, ${name}!"))
    }
}
