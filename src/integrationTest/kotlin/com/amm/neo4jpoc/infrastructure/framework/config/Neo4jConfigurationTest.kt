package com.amm.neo4jpoc.infrastructure.framework.config

import org.neo4j.ogm.session.SessionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableTransactionManagement
@Profile ("integration-test")
class Neo4jConfigurationTest {
    @Bean
    fun transactionManager(
        sessionFactory: SessionFactory
    ): Neo4jTransactionManager =
        Neo4jTransactionManager(sessionFactory)
}