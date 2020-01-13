package com.amm.neo4jpoc.infrastructure.framework.config

import com.amm.neo4jpoc.application.getmovies.GetMoviesService
import com.amm.neo4jpoc.infrastructure.framework.repository.MovieRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseServicesConfiguration {

    @Bean
    fun getMoviesService(
        movieRepository: MovieRepository
    ) = GetMoviesService(movieRepository)
}