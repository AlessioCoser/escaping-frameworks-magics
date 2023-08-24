package com.example

import java.lang.System.getenv

data class Config(
    val serverPort: Int = 8080,
    val exampleInitial: Long = (getenv("INITIAL") ?: "0").toLong()
)