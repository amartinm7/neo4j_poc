package com.amm.neo4jpoc.application.getmovies

import com.amm.neo4jpoc.domain.Movie
import com.amm.neo4jpoc.infrastructure.framework.repository.MovieRepository

class GetMoviesService (
    private val movieRepository: MovieRepository
) {
    fun execute(): GetMoviesServiceResponse = movieRepository.findAll().toGetMoviesServiceResponse()
}

fun Iterable<Movie>.toGetMoviesServiceResponse() =
    GetMoviesServiceResponse (
        movies = this.map { it.toGetMovieServiceResponse() }
    )

fun Movie.toGetMovieServiceResponse () =
    GetMovieServiceResponse (
        this.title,
        this.author,
        this.year
    )

data class GetMoviesServiceResponse (
    val movies: List<GetMovieServiceResponse>
)

data class GetMovieServiceResponse (
    val title: String,
    val author: String,
    val year: String
)

