package com.example

import io.javalin.Javalin

fun main(args: Array<String>) {
    Application().start(args)
}

class Application(private val config: Config = Config()): AutoCloseable {
    private val dependencies = AppDependencies(config)
    private val app = Javalin.create().routes {
        dependencies.greetingController.routes()
    }

    fun start(args: Array<String>): Application {
        app.start(config.serverPort)
        return this
    }

    override fun close() {
        app.close()
    }
}
