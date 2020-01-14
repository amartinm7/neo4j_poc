package com.amm.neo4jpoc.infrastructure.framework.config

import com.amm.neo4jpoc.application.getmovies.GetMoviesService
import com.amm.neo4jpoc.application.savemovies.SaveMovieService
import com.amm.neo4jpoc.infrastructure.framework.repository.MovieRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseServicesConfiguration {

    @Bean
    fun getMoviesService(
        movieRepository: MovieRepository
    ) = GetMoviesService(movieRepository)

    @Bean
    fun saveMovieService(
        movieRepository: MovieRepository
    ) = SaveMovieService(movieRepository)
}