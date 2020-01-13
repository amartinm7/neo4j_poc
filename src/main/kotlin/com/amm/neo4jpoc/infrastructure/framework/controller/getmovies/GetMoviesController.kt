package com.amm.neo4jpoc.infrastructure.framework.controller.getmovies

import com.amm.neo4jpoc.application.getmovies.GetMoviesService
import com.amm.neo4jpoc.application.getmovies.GetMoviesServiceResponse
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/movies/")
class GetMoviesController (
    val getMoviesService : GetMoviesService
) : GetMoviesAPIController{

    @GetMapping
    override fun getMovies(): ResponseEntity<GetMoviesHttpResponse> =
        getMoviesService.execute().toHttpResponse()

}

private fun GetMoviesServiceResponse.toHttpResponse(): ResponseEntity<GetMoviesHttpResponse> =
    ResponseEntity.ok(
        GetMoviesHttpResponse(
            movies = emptyList()
        )
    )

class GetMoviesHttpResponse (
    @JsonProperty(value = "movies") val movies: List<GetMovieHttpResponse>
)

class GetMovieHttpResponse (
    @JsonProperty(value = "title") val title: String,
    @JsonProperty(value = "author") val author: String,
    @JsonProperty(value = "year") val year: String
)

