package com.amm.neo4jpoc.infrastructure.framework.repository

import assertk.assertThat
import com.amm.neo4jpoc.domain.Movie
import com.amm.neo4jpoc.infrastructure.framework.SpringBootIntegrationWithDocker
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration
import org.springframework.context.annotation.Import

@Import(Neo4jDataAutoConfiguration::class)
class MovieRepositoryShould: SpringBootIntegrationWithDocker() {

    @Autowired
    private lateinit var movieRepository: MovieRepository

    @Test
    fun `save movie`() {
        val movie = Movie (
            id = 1,
            title = "American Beauty",
            author = "Sam Mendes",
            year = "1999"
        )
        assertThat { movieRepository.save(movie) }.returnedValue { movie }
    }
}