package com.amm.neo4jpoc.application.savemovies

import com.amm.neo4jpoc.domain.Movie
import com.amm.neo4jpoc.infrastructure.framework.repository.MovieRepository

class SaveMovieService(
    private val movieRepository: MovieRepository) {

    fun execute(
        saveMovieServiceRequest: SaveMovieServiceRequest): SaveMovieServiceResponse =
        saveMovieServiceRequest.toDomain().let{
            movieRepository.save(it).toSaveMovieServiceResponse()
        }
}

private fun SaveMovieServiceRequest.toDomain() =
    Movie (
        id = this.id,
        title = this.title,
        author = this.author,
        year = this.year
    )

private fun Movie.toSaveMovieServiceResponse() =
    SaveMovieServiceResponse(
        id = this.id,
        title = this.title,
        author = this.author,
        year = this.year
    )

data class SaveMovieServiceRequest(
    val id: Long,
    val title: String,
    val author: String,
    val year: String
)

data class SaveMovieServiceResponse (
    val id: Long,
    val title: String,
    val author: String,
    val year: String
)
