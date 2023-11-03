package com.example

class AppConfig(props: Properties) {
    val counterService = CounterService(props.exampleInitial)
    val greetingController = GreetingController(counterService)
}