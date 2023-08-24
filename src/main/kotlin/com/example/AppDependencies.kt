package com.example

class AppDependencies(props: Config) {
    val counterService = CounterService(props.exampleInitial)
    val greetingController = GreetingController(counterService)
}