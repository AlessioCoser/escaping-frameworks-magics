package com.example

class AppConfig {
    val props = Properties()
    val counterService = CounterService(props.exampleInitial)
    val greetingController = GreetingController(counterService)
}