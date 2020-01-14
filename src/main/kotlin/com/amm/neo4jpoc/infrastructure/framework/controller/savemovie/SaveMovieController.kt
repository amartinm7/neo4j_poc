package com.amm.neo4jpoc.infrastructure.framework.controller.savemovie

import com.amm.neo4jpoc.application.savemovies.SaveMovieService
import com.amm.neo4jpoc.application.savemovies.SaveMovieServiceRequest
import com.amm.neo4jpoc.application.savemovies.SaveMovieServiceResponse
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/movies")
class SaveMovieController(
    private val saveMovieService: SaveMovieService
): SaveMoviesAPIController {

    @PostMapping
    override fun saveMovies(
        saveMovieHttpRequest: SaveMovieHttpRequest
    ): ResponseEntity<SaveMovieHttpResponse> =
        saveMovieService.execute(
            saveMovieHttpRequest.toSaveMovieServiceRequest()
        ).toHttpResponse()
}

private fun SaveMovieHttpRequest.toSaveMovieServiceRequest(): SaveMovieServiceRequest =
    SaveMovieServiceRequest (
        id = this.id,
        title = this.title,
        author = this.author,
        year = this.year
    )

fun SaveMovieServiceResponse.toHttpResponse(): ResponseEntity<SaveMovieHttpResponse> =
    ResponseEntity(
        SaveMovieHttpResponse(
            id = this.id,
            title = this.title,
            author = this.author,
            year = this.year
        ),
        HttpStatus.OK
    )

class SaveMovieHttpRequest (
    val id: Long,
    val title: String,
    val author: String,
    val year: String
)

class SaveMovieHttpResponse (
    @JsonProperty(value = "id") val id: Long,
    @JsonProperty(value = "title") val title: String,
    @JsonProperty(value = "author") val author: String,
    @JsonProperty(value = "year") val year: String
)
