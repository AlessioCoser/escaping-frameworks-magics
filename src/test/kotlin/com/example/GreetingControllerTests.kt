package com.example

import net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import topinambur.Http

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GreetingControllerTests {
    private val application = Application()
    private val client = Http(baseUrl = "http://localhost:8080")

    @Test
    fun noParamGreetingShouldReturnDefaultMessage() {
        val response = client.get("/greeting")
        assertThat(response.statusCode).isEqualTo(200)
        assertThatJson(response.body).inPath("$.content").isEqualTo("Hello, World!")
    }

    @Test
    fun paramGreetingShouldReturnTailoredMessage() {
        val response = client.get("/greeting?name=Spring Community")
        assertThat(response.statusCode).isEqualTo(200)
        assertThatJson(response.body).inPath("$.content").isEqualTo("Hello, Spring Community!")
    }

    @BeforeAll
    fun beforeAll() {
        application.start(emptyArray())
    }

    @AfterAll
    fun afterAll() {
        application.stop()
    }
}
