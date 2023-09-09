package com.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.RouterFunction
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

@Configuration
@SpringBootApplication
class Application {
    @Bean
    fun router(greeting: GreetingController): RouterFunction<ServerResponse> {
        return router {
            greeting.routes(this)
        }
    }
}
