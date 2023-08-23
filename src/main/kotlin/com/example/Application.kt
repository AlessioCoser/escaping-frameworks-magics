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
class Application: AutoCloseable {
    private val props: Properties = Properties()
    private val config: AppConfig = AppConfig(props)
    private var appContext: ConfigurableApplicationContext? = null
    private val app = SpringApplication(Application::class.java).apply {
        setDefaultProperties(mapOf("server.port" to props.serverPort))
        addInitializers(beans {
            bean {
                router {
                    config.greetingController.routes(this)
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
