package com.amm.neo4jpoc.infrastructure.framework.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfiguration {
    //TODO there a lot of endpoints published with actuator and so on, to see them comment the .apis line
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.amm.neo4jpoc.infrastructure.framework"))
            .paths(PathSelectors.any())
            .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfo(
            "Neo4j Poc",
            "Neo4j Poc Rest API",
            "0.1.0",
            "Terms of service",
            Contact("Antonio Martin Moreno", "https://github.com/amartinm7/neo4j_poc", "amartinm7@gmail.com"),
            "License of API", "API license URL", emptyList()
        )
    }
}