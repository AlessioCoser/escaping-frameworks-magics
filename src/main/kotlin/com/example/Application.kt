package com.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.support.beans
import org.springframework.web.servlet.function.router

fun main(args: Array<String>) {
    Application().start(args)
}

@SpringBootApplication
class Application(private val config: Config = Config()): AutoCloseable {
    private val dependencies = AppDependencies(config)
    private var appContext: ConfigurableApplicationContext? = null
    private val app = SpringApplication(Application::class.java).apply {
        setDefaultProperties(mapOf("server.port" to config.serverPort))
        addInitializers(beans {
            bean {
                router {
                    dependencies.greetingController.routes(this)
                }
            }
        })
    }

    fun start(args: Array<String>): Application {
        appContext = app.run(*args)
        return this
    }

    override fun close() {
        appContext?.close()
    }
}
