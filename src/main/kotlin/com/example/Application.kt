package com.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.RouterFunction
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

fun main(args: Array<String>) {
    Application().start(args)
}

@Configuration
@SpringBootApplication
class Application: AutoCloseable {
    private val config: AppConfig = AppConfig()
    private var appContext: ConfigurableApplicationContext? = null
    private val app = SpringApplication(Application::class.java).apply {
        setDefaultProperties(mapOf("server.port" to config.properties().serverPort))
    }

    @Bean
    fun router(): RouterFunction<ServerResponse> {
        return router {
            config.greetingController().routes(this)
        }
    }

    fun start(args: Array<String>): Application {
        appContext = app.run(*args)
        return this
    }

    override fun close() {
        appContext?.close()
    }
}
