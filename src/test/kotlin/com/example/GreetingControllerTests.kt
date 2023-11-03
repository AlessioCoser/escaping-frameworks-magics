package com.example

import net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import topinambur.Http

class GreetingControllerTests {

    @Test
    fun noParamGreetingShouldReturnDefaultMessage() = runApp { client ->
        val response = client.get("/greeting")
        assertThat(response.statusCode).isEqualTo(200)
        assertThatJson(response.body).inPath("$.content").isEqualTo("Hello, World!")
    }

    @Test
    fun paramGreetingShouldReturnTailoredMessage() = runApp { client ->
        val response = client.get("/greeting?name=Spring Community")
        assertThat(response.statusCode).isEqualTo(200)
        assertThatJson(response.body).inPath("$.content").isEqualTo("Hello, Spring Community!")
    }

    private fun runApp(test: (client: Http) -> Unit) {
        val port = 8000
        val client = Http("http://localhost:${port}")
        Application(Properties(serverPort = port))
            .start(emptyArray())
            .use { test(client) }
    }
}
