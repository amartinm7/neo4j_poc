package com.amm.neo4jpoc.infrastructure.framework

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
@EnableNeo4jRepositories ("com.amm.neo4jpoc.infrastructure.framework.repository")
// @EnableWebSecurity
@EntityScan ("com.amm.neo4jpoc.infrastructure.framework.repository")
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}