package com.example

import net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GreetingControllerTests {
    private val application = Application()

    @Test
    fun noParamGreetingShouldReturnDefaultMessage() {
        val response = get("/greeting")
        assertThat(response.statusCode.value()).isEqualTo(200)
        assertThatJson(response.body).inPath("$.content").isEqualTo("Hello, World!")
    }

    @Test
    fun paramGreetingShouldReturnTailoredMessage() {
        val response = get("/greeting?name=Spring Community")
        assertThat(response.statusCode.value()).isEqualTo(200)
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

    private fun get(uri: String): ResponseEntity<String> {
        return RestTemplate().getForEntity("http://localhost:8080$uri", String::class.java)
    }
}
