package com.example

import java.lang.System.getenv

data class Properties(
    val serverPort: Int = 8080,
    val exampleInitial: Long = (getenv("INITIAL") ?: "0").toLong()
)