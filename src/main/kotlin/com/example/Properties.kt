package com.example

import java.lang.System.getenv

data class Properties(
    val serverPort: Int = 8080,
    val exampleInitial: Int = (getenv("INITIAL") ?: "0").toInt()
)