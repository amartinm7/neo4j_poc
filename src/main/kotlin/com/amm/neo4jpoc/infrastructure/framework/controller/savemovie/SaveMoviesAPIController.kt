package com.amm.neo4jpoc.infrastructure.framework.controller.savemovie

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.ResponseEntity

interface SaveMoviesAPIController {
    @ApiOperation(value = "save a movie")
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "save a movie successfully")
        ]
    )
    fun saveMovies(
        saveMovieHttpRequest: SaveMovieHttpRequest
    ): ResponseEntity<SaveMovieHttpResponse>
}
