package com.amm.neo4jpoc.infrastructure.framework.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

const val NEO4J_URL = "http://neo4j:movies@localhost:7474"

@Configuration
class Neo4jConfiguration {

    @Bean
    fun configuration(): org.neo4j.ogm.config.Configuration =
        org.neo4j.ogm.config.Configuration.Builder().uri(NEO4J_URL).build()

    @Bean
    fun sessionFactory(
        configuration: org.neo4j.ogm.config.Configuration
    ) =
        org.neo4j.ogm.session.SessionFactory(
            configuration,
            "com.amm.neo4jpoc.domain")
}