package com.example

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTests {
    @Autowired
    private val mockMvc: MockMvc? = null

    @Test
    fun noParamGreetingShouldReturnDefaultMessage() {
        mockMvc!!.perform(MockMvcRequestBuilders
            .get("/greeting"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").value("Hello, World!"))
    }

    @Test
    fun paramGreetingShouldReturnTailoredMessage() {
        mockMvc!!.perform(MockMvcRequestBuilders
            .get("/greeting")
            .param("name", "Spring Community"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").value("Hello, Spring Community!"))
    }
}
