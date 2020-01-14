package com.amm.neo4jpoc.infrastructure.framework.config

import com.amm.neo4jpoc.infrastructure.framework.repository.CrudMovieRepository
import com.amm.neo4jpoc.infrastructure.framework.repository.MovieRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MovieRepositoryConfiguration {

    @Bean
    fun movieRepository(
        crudMovieRepository: CrudMovieRepository
    ) = MovieRepository (crudMovieRepository)
}