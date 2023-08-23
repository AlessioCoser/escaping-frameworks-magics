package com.example

class AppConfig {
    fun properties() = Properties()

    fun counterService(props: Properties) = CounterService(props.exampleInitial)

    fun greetingController() = GreetingController(counterService(properties()))
}