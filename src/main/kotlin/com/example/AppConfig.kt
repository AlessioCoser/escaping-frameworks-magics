package com.example

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun properties() = Properties()

    @Bean
    fun counterService(props: Properties) = CounterService(props.exampleInitial)

    fun greetingController() = GreetingController(counterService(properties()))
}