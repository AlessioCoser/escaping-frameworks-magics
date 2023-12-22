package com.example

import io.javalin.Javalin

fun main() {
    Application().start()
}

class Application(private val config: Config = Config()) : AutoCloseable {
    private val dependencies = AppDependencies(config)
    private val app = Javalin.create().routes {
        dependencies.greetingController.routes()
    }

    val port: Int get() = app.port()

    fun start(): Application {
        app.start(config.serverPort)
        return this
    }

    override fun close() {
        app.close()
    }
}
