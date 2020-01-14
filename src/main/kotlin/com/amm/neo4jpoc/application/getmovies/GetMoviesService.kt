package com.amm.neo4jpoc.application.getmovies

import com.amm.neo4jpoc.domain.Movie
import com.amm.neo4jpoc.infrastructure.framework.repository.MovieRepository

class GetMoviesService (
    private val movieRepository: MovieRepository
) {
    fun execute(): GetMoviesServiceResponse =
        movieRepository.findAll().toGetMoviesServiceResponse()
}

private fun Collection<Movie>.toGetMoviesServiceResponse(): GetMoviesServiceResponse =
    GetMoviesServiceResponse(
        movies = this.map { it.toGetMovieServiceResponse() }
    )

private fun Movie.toGetMovieServiceResponse(): GetMovieServiceResponse =
    GetMovieServiceResponse(
        id = this.id,
        title = this.title,
        author = this.author,
        year = this.year
    )

data class GetMoviesServiceResponse (
    val movies: List<GetMovieServiceResponse>
)

data class GetMovieServiceResponse(
    val id: Long,
    val title: String,
    val author: String,
    val year: String
)

