package com.amm.neo4jpoc.infrastructure.framework

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
@EnableNeo4jRepositories
//@EnableWebSecurity
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}