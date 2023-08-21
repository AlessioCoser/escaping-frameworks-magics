package com.example

import org.springframework.stereotype.Service
import java.lang.System.getenv

@Service
data class Properties(
    val serverPort: Int = 8080,
    val exampleInitial: Int = (getenv("INITIAL") ?: "0").toInt()
)