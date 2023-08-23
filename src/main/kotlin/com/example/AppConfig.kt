package com.example

import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig : WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Bean
    fun properties() = Properties()

    @Bean
    fun counterService(props: Properties) = CounterService(props.exampleInitial)

    override fun customize(factory: ConfigurableServletWebServerFactory) {
        factory.setPort(properties().serverPort)
    }
}