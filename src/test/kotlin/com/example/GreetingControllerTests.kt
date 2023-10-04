package com.example

import net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTests {
    @Autowired
    private val mockMvc: MockMvc? = null

    @Test
    fun noParamGreetingShouldReturnDefaultMessage() {
        val response = mockMvc!!.perform(get("/greeting")).andReturn().response
        assertThat(response.status).isEqualTo(200)
        assertThatJson(response.contentAsString).inPath("$.content").isEqualTo("Hello, World!")
    }

    @Test
    fun paramGreetingShouldReturnTailoredMessage() {
        val response = mockMvc!!.perform(
            get("/greeting").param("name", "Spring Community")
        ).andReturn().response
        assertThat(response.status).isEqualTo(200)
        assertThatJson(response.contentAsString).inPath("$.content").isEqualTo("Hello, Spring Community!")
    }
}
